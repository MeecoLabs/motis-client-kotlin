/*
 * Copyright (c) 2026 MeecoLabs
 * SPDX-License-Identifier: Apache-2.0
 */

package eu.meecolabs.motis.client

import eu.meecolabs.motis.client.models.TransitMode
import eu.meecolabs.motis.client.models.request.OneToManyIntermodalRequest
import eu.meecolabs.motis.client.models.request.OneToManyRequest
import eu.meecolabs.motis.client.models.request.RefreshItineraryRequest
import eu.meecolabs.motis.client.utils.TestUtils.createTestService
import eu.meecolabs.motis.client.utils.TestUtils.enqueueFixture
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import kotlin.time.Instant

class MotisServiceTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var service: MotisService

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.start()

        service = createTestService(mockWebServer)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    // Section: - Routing

    @Test
    fun testPlan() = runTest {
        mockWebServer.enqueueFixture("fixtures/plan.json")

        val response = service.plan(
            fromPlace = "48.1,11.5",
            toPlace = "48.2,11.6"
        )
        val request = mockWebServer.takeRequest()

        assertTrue(request.path?.contains("v6/plan") == true)
        assertEquals("GET", request.method)

        assertNotNull(response.from)
        assertNotNull(response.to)
    }

    @Test
    fun testOneToManyGet() = runTest {
        mockWebServer.enqueueFixture("fixtures/one_to_many.json")

        val response = service.oneToMany(
            one = "48.138;11.576",
            many = listOf("48.139;11.577"),
            mode = listOf(TransitMode.WALK),
            max = 3600.0,
            maxMatchingDistance = 500.0,
            arriveBy = false
        )
        val request = mockWebServer.takeRequest()

        assertTrue(request.path?.contains("v1/one-to-many") == true)
        assertEquals("GET", request.method)

        assertNotNull(response)
    }

    @Test
    fun testOneToManyPost() = runTest {
        mockWebServer.enqueueFixture("fixtures/one_to_many.json")

        val requestBody = OneToManyRequest(
            one = "48.138;11.576",
            many = listOf("48.139;11.577"),
            mode = listOf(TransitMode.WALK),
            max = 3600.0,
            maxMatchingDistance = 500.0,
            arriveBy = false
        )
        val response = service.postOneToMany(requestBody)
        val request = mockWebServer.takeRequest()

        assertTrue(request.path?.contains("v1/one-to-many") == true)
        assertEquals("POST", request.method)

        assertNotNull(response)
    }

    @Test
    fun testOneToManyIntermodalGet() = runTest {
        mockWebServer.enqueueFixture("fixtures/one_to_many_intermodal.json")

        val response = service.oneToManyIntermodal(
            one = "48.138;11.576",
            many = listOf("48.139;11.577")
        )
        val request = mockWebServer.takeRequest()

        assertTrue(request.path?.contains("experimental/one-to-many-intermodal") == true)
        assertEquals("GET", request.method)

        assertNotNull(response.streetDurations)
    }

    @Test
    fun testOneToManyIntermodalPost() = runTest {
        mockWebServer.enqueueFixture("fixtures/one_to_many_intermodal.json")

        val requestBody = OneToManyIntermodalRequest(
            one = "48.138;11.576",
            many = listOf("48.139;11.577")
        )
        val response = service.postOneToManyIntermodal(requestBody)
        val request = mockWebServer.takeRequest()

        assertTrue(request.path?.contains("experimental/one-to-many-intermodal") == true)
        assertEquals("POST", request.method)

        assertNotNull(response.streetDurations)
    }

    @Test
    fun testOneToAll() = runTest {
        mockWebServer.enqueueFixture("fixtures/one_to_all.json")

        val response = service.oneToAll(
            one = "de-DELFI_de:09563:2110",
            maxTravelTime = 300
        )
        val request = mockWebServer.takeRequest()

        assertTrue(request.path?.contains("v6/one-to-all") == true)
        assertEquals("GET", request.method)

        assertNotNull(response.one)
    }

    // Section: - Geocode

    @Test
    fun testReverseGeocode() = runTest {
        mockWebServer.enqueueFixture("fixtures/reverse_geocode.json")

        val response = service.reverseGeocode(place = "48.138,11.576")
        val request = mockWebServer.takeRequest()

        assertTrue(request.path?.contains("v1/reverse-geocode") == true)
        assertEquals("GET", request.method)

        assertTrue(response.isNotEmpty())
    }

    @Test
    fun testGeocode() = runTest {
        mockWebServer.enqueueFixture("fixtures/geocode.json")

        val response = service.geocode(text = "Main Station")
        val request = mockWebServer.takeRequest()

        assertTrue(request.path?.contains("v1/geocode") == true)
        assertEquals("GET", request.method)

        assertTrue(response.isNotEmpty())
    }

    // Section: - Timetable

    @Test
    fun testTrip() = runTest {
        mockWebServer.enqueueFixture("fixtures/trip.json")

        val response = service.trip(tripId = "trip_123")
        val request = mockWebServer.takeRequest()

        assertTrue(request.path?.contains("v6/trip") == true)
        assertEquals("GET", request.method)

        assertNotNull(response.id)
    }

    @Test
    fun testRefreshItineraryGet() = runTest {
        mockWebServer.enqueueFixture("fixtures/refresh_itinerary.json")

        val response = service.refreshItinerary(itineraryId = "trip_123")
        val request = mockWebServer.takeRequest()

        assertTrue(request.path?.contains("v6/refresh-itinerary") == true)
        assertEquals("GET", request.method)

        assertNotNull(response.id)
    }

    @Test
    fun testRefreshItineraryPost() = runTest {
        mockWebServer.enqueueFixture("fixtures/refresh_itinerary.json")

        val requestBody = RefreshItineraryRequest(
            itineraryId = "trip_123"
        )
        val response = service.postRefreshItinerary(requestBody)
        val request = mockWebServer.takeRequest()

        assertTrue(request.path?.contains("v6/refresh-itinerary") == true)
        assertEquals("POST", request.method)

        assertNotNull(response.id)
    }

    @Test
    fun testStoptimes() = runTest {
        mockWebServer.enqueueFixture("fixtures/stoptimes.json")

        val response = service.stoptimes(stopId = "stop_123")
        val request = mockWebServer.takeRequest()

        assertTrue(request.path?.contains("v6/stoptimes") == true)
        assertEquals("GET", request.method)

        assertNotNull(response.place)
    }

    // Section: - Map

    @Test
    fun testMapTrips() = runTest {
        mockWebServer.enqueueFixture("fixtures/map_trips.json")

        val now = Instant.parse("2026-03-31T10:00:00Z")
        val response = service.map(
            zoom = 10.0,
            min = "48.0,11.0",
            max = "49.0,12.0",
            startTime = now,
            endTime = now
        )
        val request = mockWebServer.takeRequest()

        assertTrue(request.path?.contains("v6/map/trips") == true)
        assertEquals("GET", request.method)

        assertNotNull(response)
    }

    @Test
    fun testMapInitial() = runTest {
        mockWebServer.enqueueFixture("fixtures/map_initial.json")

        val response = service.mapInitial()
        val request = mockWebServer.takeRequest()

        assertTrue(request.path?.contains("v1/map/initial") == true)
        assertEquals("GET", request.method)

        assertNotNull(response.serverConfig)
    }

    @Test
    fun testMapStops() = runTest {
        mockWebServer.enqueueFixture("fixtures/map_stops.json")

        val response = service.mapStops(
            min = "48.0,11.0",
            max = "49.0,12.0"
        )
        val request = mockWebServer.takeRequest()

        assertTrue(request.path?.contains("v6/map/stops") == true)
        assertEquals("GET", request.method)

        assertTrue(response.isNotEmpty())
    }

    @Test
    fun testMapLevels() = runTest {
        mockWebServer.enqueueFixture("fixtures/map_levels.json")

        val response = service.mapLevels(
            min = "48.0,11.0",
            max = "49.0,12.0"
        )
        val request = mockWebServer.takeRequest()

        assertTrue(request.path?.contains("v1/map/levels") == true)
        assertEquals("GET", request.method)

        assertNotNull(response)
    }

    @Test
    fun testMapRoutes() = runTest {
        mockWebServer.enqueueFixture("fixtures/map_routes.json")

        val response = service.mapRoutes(
            zoom = 10.0,
            min = "48.0,11.0",
            max = "49.0,12.0"
        )
        val request = mockWebServer.takeRequest()

        assertTrue(request.path?.contains("experimental/map/routes") == true)
        assertEquals("GET", request.method)

        assertNotNull(response.routes)
    }

    @Test
    fun testMapRouteDetails() = runTest {
        mockWebServer.enqueueFixture("fixtures/map_route_details.json")

        val response = service.mapRouteDetails(routeIdx = 0)
        val request = mockWebServer.takeRequest()

        assertTrue(request.path?.contains("experimental/map/route-details") == true)
        assertEquals("GET", request.method)

        assertNotNull(response.routes)
    }

    @Test
    fun testRentals() = runTest {
        mockWebServer.enqueueFixture("fixtures/rentals.json")

        val response = service.rentals()
        val request = mockWebServer.takeRequest()

        assertTrue(request.path?.contains("v1/rentals") == true)
        assertEquals("GET", request.method)

        assertNotNull(response.stations)
    }

    // Section: - Health

    @Test
    fun testHealth() = runTest {
        mockWebServer.enqueueFixture("fixtures/health.json")

        val response = service.health()
        val request = mockWebServer.takeRequest()

        assertTrue(request.path?.contains("v1/health") == true)
        assertEquals("GET", request.method)

        assertTrue(response.rt)
        assertTrue(response.gbfs)
    }
}
