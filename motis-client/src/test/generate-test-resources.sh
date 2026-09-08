#!/bin/sh
#
# Copyright (c) 2026 MeecoLabs
# SPDX-License-Identifier: Apache-2.0
#

set +e

SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
BASE_URL="${MOTIS_API_URL:-https://api.transitous.org/api}"
USER_AGENT="${MOTIS_USER_AGENT:-MotisClientTest/1.0}"
OUTPUT_DIR="$SCRIPT_DIR/resources/fixtures"

mkdir -p "$OUTPUT_DIR"

echo "Fetching sample responses from $BASE_URL..."

fetch() {
  endpoint="$1"
  filename="$2"
  limit="$3"

  echo "  -> Fetching $filename"
  if [ -n "$limit" ]; then
    curl -sS -H "User-Agent: $USER_AGENT" "$BASE_URL/$endpoint" | jq "if type == \"array\" then .[0:$limit] else . end" > "$OUTPUT_DIR/$filename"
  else
    curl -sS -H "User-Agent: $USER_AGENT" "$BASE_URL/$endpoint" | jq . > "$OUTPUT_DIR/$filename"
  fi
}

# Routing

fetch "v6/plan?fromPlace=52.5200,13.4050&toPlace=52.5167,13.3777&numItineraries=1" "plan.json"
fetch "v1/one-to-many?one=48.1401;11.5587&many=48.1390;11.5660&mode=WALK&max=3600&maxMatchingDistance=1000&arriveBy=false&withDistance=true" "one_to_many.json" 3
fetch "experimental/one-to-many-intermodal?one=48.1401;11.5587&many=48.1390;11.5660&transitModes=SUBWAY&transitModes=TRAM&transitModes=REGIONAL_RAIL" "one_to_many_intermodal.json"
fetch "v6/one-to-all?one=48.1401,11.5587&maxTravelTime=30" "one_to_all.json"

# Geocode

fetch "v1/reverse-geocode?place=48.1401,11.5587" "reverse_geocode.json" 3
fetch "v1/geocode?text=Glasgow%20Central%20Station" "geocode.json" 3

# Timetable

fetch "v6/stoptimes?stopId=fr-horaires-sncf_FR::LMO:719d92c0-3a69-11e9-8417-bb1d8a705241:&n=3" "stoptimes.json"

LATEST_TRIP_ID=$(jq -r '.stopTimes[0].tripId' "$OUTPUT_DIR/stoptimes.json")
fetch "v6/trip?tripId=$LATEST_TRIP_ID" "trip.json"

RAW_ITINERARY_ID=$(jq -r '.id' "$OUTPUT_DIR/trip.json")
LATEST_ITINERARY_ID=$(jq -rn --arg id "$RAW_ITINERARY_ID" '$id | @uri')
fetch "v6/refresh-itinerary?itineraryId=$LATEST_ITINERARY_ID" "refresh_itinerary.json"

# Map

NOW_TIME=$(date -u +"%Y-%m-%dT%H:%M:%SZ")
FUTURE_TIME=$(date -u -v+1H +"%Y-%m-%dT%H:%M:%SZ" 2>/dev/null || date -u -d "+1 hour" +"%Y-%m-%dT%H:%M:%SZ" 2>/dev/null || echo "$NOW_TIME")

fetch "v6/map/trips?zoom=15&min=48.139,11.557&max=48.141,11.560&startTime=$NOW_TIME&endTime=$FUTURE_TIME" "map_trips.json" 3
fetch "v1/map/initial" "map_initial.json"
fetch "v6/map/stops?min=48.139,11.557&max=48.141,11.560" "map_stops.json" 5
fetch "v1/map/levels?min=48.139,11.555&max=48.142,11.560" "map_levels.json"
fetch "experimental/map/routes?zoom=18&min=53.70,7.15&max=53.71,7.16" "map_routes.json"

ROUTE_IDX=$(jq -r '.routes[0].routeIdx' "$OUTPUT_DIR/map_routes.json")
fetch "experimental/map/route-details?routeIdx=$ROUTE_IDX" "map_route_details.json"

fetch "v1/rentals?point=48.1401,11.5587&radius=300" "rentals.json"

# Health

fetch "v1/health" "health.json"

echo "Test resources saved to $OUTPUT_DIR"
