/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client

import eu.meecolabs.motis.client.models.ElevationCosts
import eu.meecolabs.motis.client.models.LocationType
import eu.meecolabs.motis.client.models.PedestrianProfile
import eu.meecolabs.motis.client.models.RentalFormFactor
import eu.meecolabs.motis.client.models.RentalPropulsionType
import eu.meecolabs.motis.client.models.RoutingAlgorithm
import eu.meecolabs.motis.client.models.StopTimeDirection
import eu.meecolabs.motis.client.models.TransitMode
import eu.meecolabs.motis.client.models.request.OneToManyIntermodalRequest
import eu.meecolabs.motis.client.models.request.OneToManyRequest
import eu.meecolabs.motis.client.models.request.RefreshItineraryRequest
import eu.meecolabs.motis.client.models.response.GeocodeResponse
import eu.meecolabs.motis.client.models.response.HealthResponse
import eu.meecolabs.motis.client.models.response.MapInitialResponse
import eu.meecolabs.motis.client.models.response.MapRoutesResponse
import eu.meecolabs.motis.client.models.response.MapStopsResponse
import eu.meecolabs.motis.client.models.response.MapTripsResponse
import eu.meecolabs.motis.client.models.response.OneToAllResponse
import eu.meecolabs.motis.client.models.response.OneToManyIntermodalResponse
import eu.meecolabs.motis.client.models.response.OneToManyResponse
import eu.meecolabs.motis.client.models.response.PlanResponse
import eu.meecolabs.motis.client.models.response.RentalsResponse
import eu.meecolabs.motis.client.models.response.StopTimesResponse
import eu.meecolabs.motis.client.models.response.TripResponse
import eu.meecolabs.motis.client.utils.ExperimentalEndpoint
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import kotlin.time.Instant

interface MotisService {

    // Section: - Routing

    @GET("v6/plan")
    suspend fun plan(
        @Query("fromPlace") fromPlace: String,
        @Query("toPlace") toPlace: String,
        @Query("radius") radius: Double? = null,
        @Query("via") via: List<String>? = null,
        @Query("viaMinimumStay") viaMinimumStay: List<Int>? = null,
        @Query("time") time: Instant? = null,
        @Query("maxTransfers") maxTransfers: Int? = null,
        @Query("maxTravelTime") maxTravelTime: Int? = null,
        @Query("minTransferTime") minTransferTime: Int? = null,
        @Query("additionalTransferTime") additionalTransferTime: Int? = null,
        @Query("transferTimeFactor") transferTimeFactor: Double? = null,
        @Query("maxMatchingDistance") maxMatchingDistance: Double? = null,
        @Query("pedestrianProfile") pedestrianProfile: PedestrianProfile? = null,
        @Query("pedestrianSpeed") pedestrianSpeed: Double? = null,
        @Query("cyclingSpeed") cyclingSpeed: Double? = null,
        @Query("elevationCosts") elevationCosts: ElevationCosts? = null,
        @Query("useRoutedTransfers") useRoutedTransfers: Boolean? = null,
        @Query("detailedTransfers") detailedTransfers: Boolean? = null,
        @Query("detailedLegs") detailedLegs: Boolean? = null,
        @Query("joinInterlinedLegs") joinInterlinedLegs: Boolean? = null,
        @Query("transitModes") transitModes: List<@JvmSuppressWildcards TransitMode>? = null,
        @Query("directModes") directModes: List<@JvmSuppressWildcards TransitMode>? = null,
        @Query("preTransitModes") preTransitModes: List<@JvmSuppressWildcards TransitMode>? = null,
        @Query("postTransitModes") postTransitModes: List<@JvmSuppressWildcards TransitMode>? = null,
        @Query("directRentalFormFactors") directRentalFormFactors: List<@JvmSuppressWildcards RentalFormFactor>? = null,
        @Query("preTransitRentalFormFactors") preTransitRentalFormFactors: List<@JvmSuppressWildcards RentalFormFactor>? = null,
        @Query("postTransitRentalFormFactors") postTransitRentalFormFactors: List<@JvmSuppressWildcards RentalFormFactor>? = null,
        @Query("directRentalPropulsionTypes") directRentalPropulsionTypes: List<@JvmSuppressWildcards RentalPropulsionType>? = null,
        @Query("preTransitRentalPropulsionTypes") preTransitRentalPropulsionTypes: List<@JvmSuppressWildcards RentalPropulsionType>? = null,
        @Query("postTransitRentalPropulsionTypes") postTransitRentalPropulsionTypes: List<@JvmSuppressWildcards RentalPropulsionType>? = null,
        @Query("directRentalProviders") directRentalProviders: List<String>? = null,
        @Query("directRentalProviderGroups") directRentalProviderGroups: List<String>? = null,
        @Query("preTransitRentalProviders") preTransitRentalProviders: List<String>? = null,
        @Query("preTransitRentalProviderGroups") preTransitRentalProviderGroups: List<String>? = null,
        @Query("postTransitRentalProviders") postTransitRentalProviders: List<String>? = null,
        @Query("postTransitRentalProviderGroups") postTransitRentalProviderGroups: List<String>? = null,
        @Query("ignoreDirectRentalReturnConstraints") ignoreDirectRentalReturnConstraints: Boolean? = null,
        @Query("ignorePreTransitRentalReturnConstraints") ignorePreTransitRentalReturnConstraints: Boolean? = null,
        @Query("ignorePostTransitRentalReturnConstraints") ignorePostTransitRentalReturnConstraints: Boolean? = null,
        @Query("numItineraries") numItineraries: Int? = null,
        @Query("maxItineraries") maxItineraries: Int? = null,
        @Query("pageCursor") pageCursor: String? = null,
        @Query("timetableView") timetableView: Boolean? = null,
        @Query("arriveBy") arriveBy: Boolean? = null,
        @Query("searchWindow") searchWindow: Int? = null,
        @Query("requireBikeTransport") requireBikeTransport: Boolean? = null,
        @Query("requireCarTransport") requireCarTransport: Boolean? = null,
        @Query("maxPreTransitTime") maxPreTransitTime: Int? = null,
        @Query("maxPostTransitTime") maxPostTransitTime: Int? = null,
        @Query("maxDirectTime") maxDirectTime: Int? = null,
        @Query("fastestDirectFactor") fastestDirectFactor: Double? = null,
        @Query("timeout") timeout: Int? = null,
        @Query("passengers") passengers: Int? = null,
        @Query("luggage") luggage: Int? = null,
        @Query("slowDirect") slowDirect: Boolean? = null,
        @Query("fastestSlowDirectFactor") fastestSlowDirectFactor: Double? = null,
        @Query("withFares") withFares: Boolean? = null,
        @Query("numLegAlternatives") numLegAlternatives: Int? = null,
        @Query("withScheduledSkippedStops") withScheduledSkippedStops: Boolean? = null,
        @Query("language") language: List<String>? = null,
        @Query("algorithm") algorithm: List<@JvmSuppressWildcards RoutingAlgorithm>? = null,
    ): PlanResponse

    @GET("v1/one-to-many")
    suspend fun oneToMany(
        @Query("one") one: String,
        @Query("many") many: List<String>,
        @Query("mode") mode: List<@JvmSuppressWildcards TransitMode>,
        @Query("max") max: Double,
        @Query("maxMatchingDistance") maxMatchingDistance: Double,
        @Query("elevationCosts") elevationCosts: ElevationCosts? = null,
        @Query("arriveBy") arriveBy: Boolean,
        @Query("withDistance") withDistance: Boolean? = null
    ): OneToManyResponse

    @POST("v1/one-to-many")
    suspend fun postOneToMany(
        @Body body: OneToManyRequest
    ): OneToManyResponse

    @ExperimentalEndpoint
    @GET("experimental/one-to-many-intermodal")
    suspend fun oneToManyIntermodal(
        @Query("one") one: String,
        @Query("many") many: List<String>,
        @Query("time") time: Instant? = null,
        @Query("maxTravelTime") maxTravelTime: Int? = null,
        @Query("maxMatchingDistance") maxMatchingDistance: Double? = null,
        @Query("arriveBy") arriveBy: Boolean? = null,
        @Query("maxTransfers") maxTransfers: Int? = null,
        @Query("minTransferTime") minTransferTime: Int? = null,
        @Query("additionalTransferTime") additionalTransferTime: Int? = null,
        @Query("transferTimeFactor") transferTimeFactor: Double? = null,
        @Query("useRoutedTransfers") useRoutedTransfers: Boolean? = null,
        @Query("pedestrianProfile") pedestrianProfile: PedestrianProfile? = null,
        @Query("pedestrianSpeed") pedestrianSpeed: Double? = null,
        @Query("cyclingSpeed") cyclingSpeed: Double? = null,
        @Query("elevationCosts") elevationCosts: ElevationCosts? = null,
        @Query("transitModes") transitModes: List<@JvmSuppressWildcards TransitMode>? = null,
        @Query("preTransitModes") preTransitModes: List<@JvmSuppressWildcards TransitMode>? = null,
        @Query("postTransitModes") postTransitModes: List<@JvmSuppressWildcards TransitMode>? = null,
        @Query("directMode") directMode: List<@JvmSuppressWildcards TransitMode>? = null,
        @Query("maxPreTransitTime") maxPreTransitTime: Int? = null,
        @Query("maxPostTransitTime") maxPostTransitTime: Int? = null,
        @Query("maxDirectTime") maxDirectTime: Int? = null,
        @Query("withDistance") withDistance: Boolean? = null,
        @Query("requireBikeTransport") requireBikeTransport: Boolean? = null,
        @Query("requireCarTransport") requireCarTransport: Boolean? = null
    ): OneToManyIntermodalResponse

    @ExperimentalEndpoint
    @POST("experimental/one-to-many-intermodal")
    suspend fun postOneToManyIntermodal(
        @Body body: OneToManyIntermodalRequest
    ): OneToManyIntermodalResponse

    @GET("v6/one-to-all")
    suspend fun oneToAll(
        @Query("one") one: String,
        @Query("time") time: Instant? = null,
        @Query("maxTravelTime") maxTravelTime: Int,
        @Query("arriveBy") arriveBy: Boolean? = null,
        @Query("maxTransfers") maxTransfers: Int? = null,
        @Query("minTransferTime") minTransferTime: Int? = null,
        @Query("additionalTransferTime") additionalTransferTime: Int? = null,
        @Query("transferTimeFactor") transferTimeFactor: Double? = null,
        @Query("maxMatchingDistance") maxMatchingDistance: Double? = null,
        @Query("useRoutedTransfers") useRoutedTransfers: Boolean? = null,
        @Query("pedestrianProfile") pedestrianProfile: PedestrianProfile? = null,
        @Query("pedestrianSpeed") pedestrianSpeed: Double? = null,
        @Query("cyclingSpeed") cyclingSpeed: Double? = null,
        @Query("elevationCosts") elevationCosts: ElevationCosts? = null,
        @Query("transitModes") transitModes: List<@JvmSuppressWildcards TransitMode>? = null,
        @Query("preTransitModes") preTransitModes: List<@JvmSuppressWildcards TransitMode>? = null,
        @Query("postTransitModes") postTransitModes: List<@JvmSuppressWildcards TransitMode>? = null,
        @Query("requireBikeTransport") requireBikeTransport: Boolean? = null,
        @Query("requireCarTransport") requireCarTransport: Boolean? = null,
        @Query("maxPreTransitTime") maxPreTransitTime: Int? = null,
        @Query("maxPostTransitTime") maxPostTransitTime: Int? = null
    ): OneToAllResponse

    // Section: - Geocode

    @GET("v1/reverse-geocode")
    suspend fun reverseGeocode(
        @Query("place") place: String,
        @Query("type") type: LocationType? = null,
        @Query("numResults") numResults: Int? = null
    ): List<GeocodeResponse>

    @GET("v1/geocode")
    suspend fun geocode(
        @Query("text") text: String,
        @Query("language") language: List<String>? = null,
        @Query("type") type: List<@JvmSuppressWildcards LocationType>? = null,
        @Query("mode") mode: List<@JvmSuppressWildcards TransitMode>? = null,
        @Query("place") place: String? = null,
        @Query("placeBias") placeBias: Double? = null,
        @Query("numResults") numResults: Int? = null
    ): List<GeocodeResponse>

    // Section: - Timetable

    @GET("v6/trip")
    suspend fun trip(
        @Query("tripId") tripId: String,
        @Query("withScheduledSkippedStops") withScheduledSkippedStops: Boolean? = null,
        @Query("detailedLegs") detailedLegs: Boolean? = null,
        @Query("joinInterlinedLegs") joinInterlinedLegs: Boolean? = null,
        @Query("language") language: List<String>? = null
    ): TripResponse

    @GET("v6/refresh-itinerary")
    suspend fun refreshItinerary(
        @Query("itineraryId") itineraryId: String,
        @Query("requireDisplayNameMatch") requireDisplayNameMatch: Boolean? = null,
        @Query("joinInterlinedLegs") joinInterlinedLegs: Boolean? = null,
        @Query("detailedTransfers") detailedTransfers: Boolean? = null,
        @Query("detailedLegs") detailedLegs: Boolean? = null,
        @Query("withFares") withFares: Boolean? = null,
        @Query("withScheduledSkippedStops") withScheduledSkippedStops: Boolean? = null,
        @Query("numLegAlternatives") numLegAlternatives: Int? = null,
        @Query("transitModes") transitModes: List<@JvmSuppressWildcards TransitMode>? = null,
        @Query("pedestrianProfile") pedestrianProfile: PedestrianProfile? = null,
        @Query("useRoutedTransfers") useRoutedTransfers: Boolean? = null,
        @Query("requireBikeTransport") requireBikeTransport: Boolean? = null,
        @Query("requireCarTransport") requireCarTransport: Boolean? = null,
        @Query("language") language: List<String>? = null
    ): TripResponse

    @POST("v6/refresh-itinerary")
    suspend fun postRefreshItinerary(
        @Body body: RefreshItineraryRequest
    ): TripResponse

    @GET("v6/stoptimes")
    suspend fun stoptimes(
        @Query("stopId") stopId: String? = null,
        @Query("center") center: String? = null,
        @Query("time") time: Instant? = null,
        @Query("arriveBy") arriveBy: Boolean? = null,
        @Query("direction") direction: StopTimeDirection? = null,
        @Query("window") window: Int? = null,
        @Query("mode") mode: List<@JvmSuppressWildcards TransitMode>? = null,
        @Query("n") n: Int? = null,
        @Query("radius") radius: Int? = null,
        @Query("exactRadius") exactRadius: Boolean? = null,
        @Query("fetchStops") fetchStops: Boolean? = null,
        @Query("pageCursor") pageCursor: String? = null,
        @Query("withScheduledSkippedStops") withScheduledSkippedStops: Boolean? = null,
        @Query("language") language: List<String>? = null,
        @Query("withAlerts") withAlerts: Boolean? = null,
    ): StopTimesResponse

    // Section: - Map

    @GET("v6/map/trips")
    suspend fun map(
        @Query("zoom") zoom: Double,
        @Query("min") min: String,
        @Query("max") max: String,
        @Query("startTime") startTime: Instant,
        @Query("endTime") endTime: Instant,
        @Query("precision") precision: Double? = null,
        @Query("language") language: List<String>? = null
    ): MapTripsResponse

    @GET("v1/map/initial")
    suspend fun mapInitial(): MapInitialResponse

    @GET("v6/map/stops")
    suspend fun mapStops(
        @Query("min") min: String,
        @Query("max") max: String,
        @Query("grouped") grouped: Boolean? = null,
        @Query("modes") modes: List<@JvmSuppressWildcards TransitMode>? = null,
        @Query("language") language: List<String>? = null
    ): MapStopsResponse

    @GET("v1/map/levels")
    suspend fun mapLevels(
        @Query("min") min: String,
        @Query("max") max: String
    ): List<Double>

    @ExperimentalEndpoint
    @GET("experimental/map/routes")
    suspend fun mapRoutes(
        @Query("zoom") zoom: Double,
        @Query("min") min: String,
        @Query("max") max: String,
        @Query("language") language: List<String>? = null
    ): MapRoutesResponse

    @ExperimentalEndpoint
    @GET("experimental/map/route-details")
    suspend fun mapRouteDetails(
        @Query("routeIdx") routeIdx: Int,
        @Query("language") language: List<String>? = null
    ): MapRoutesResponse

    @GET("v1/rentals")
    suspend fun rentals(
        @Query("min") min: String? = null,
        @Query("max") max: String? = null,
        @Query("point") point: String? = null,
        @Query("radius") radius: Int? = null,
        @Query("providerGroups") providerGroups: List<String>? = null,
        @Query("providers") providers: List<String>? = null,
        @Query("withProviders") withProviders: Boolean? = null,
        @Query("withStations") withStations: Boolean? = null,
        @Query("withVehicles") withVehicles: Boolean? = null,
        @Query("withZones") withZones: Boolean? = null
    ): RentalsResponse

    // Section: - Health

    @GET("v1/health")
    suspend fun health(): HealthResponse
}
