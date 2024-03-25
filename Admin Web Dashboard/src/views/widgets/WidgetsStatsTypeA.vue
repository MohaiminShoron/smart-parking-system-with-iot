<template>
  <CRow :xs="{ gutter: 4 }">
    <CCol :sm="6" :xl="4" :xxl="3">
      <CWidgetStatsA color="primary">
        <template #value>
          <!-- Bind the revenue dynamically -->
          ${{ revenue }}
        </template>
        <template #title>Daily Revenues</template>
        <template #action>
          <!-- Date Picker Input -->
          <CFormInput type="date" v-model="revenueSelectedDate" @change="fetchAllRevenueData" />
        </template>
        <template #chart>
          <CChart
            type="bar"
            class="mt-3 mx-3"
            style="height: 70px"
            :data="revenueChartData"
            :options="{
              maintainAspectRatio: false,
              plugins: {
                legend: {
                  display: false,
                },
              },
              scales: {
                x: {
                  grid: {
                    display: false,
                    drawTicks: false,
                  },
                  ticks: {
                    display: false,
                  },
                },
                y: {
                  beginAtZero: true,
                  grid: {
                    display: false,
                    drawTicks: false,
                  },
                  ticks: {
                    display: false,
                  },
                },
              },
            }"
          />
        </template>
      </CWidgetStatsA>
    </CCol>

    <CCol :sm="6" :xl="4" :xxl="3">
      <CWidgetStatsA color="info">
        <template #value>
          <!-- Dynamically display the parking utilization -->
          {{ parkingUtilization }}%
        </template>
        <template #title>Parking Slot Utilization</template>
        <template #action>
          <!-- Select dropdown to choose the location -->
          <select v-model="selectedLocation" class="form-select">
            <option value="MarketMall">Market Mall</option>
            <option value="ChinookMall">Chinook Mall</option>
     
          </select>
        </template>
        <template #chart>
          <!-- Chart to display the parking utilization -->
          <CChart
            type="line"
            class="mt-3 mx-3"
            style="height: 70px"
            ref="widgetChartRef2"
            :data="{
              labels: ['', '', '', '', '', '', ''],
              datasets: [
                {
                  label: '',
                  backgroundColor: 'transparent',
                  borderColor: 'rgba(255,255,255,.55)',
                  pointBackgroundColor: getStyle('--cui-info'),
                  data: [1, 18, 9, 17, 34, 22, 11],
                },
              ],
            }"
            :options="{
              plugins: {
                legend: {
                  display: false,
                },
              },
              maintainAspectRatio: false,
              scales: {
                x: {
                  border: {
                    display: false,
                  },
                  grid: {
                    display: false,
                  },
                  ticks: {
                    display: false,
                  },
                },
                y: {
                  min: -9,
                  max: 39,
                  display: false,
                  grid: {
                    display: false,
                  },
                  ticks: {
                    display: false,
                  },
                },
              },
              elements: {
                line: {
                  borderWidth: 1,
                },
                point: {
                  radius: 4,
                  hitRadius: 10,
                  hoverRadius: 4,
                },
              },
            }"
          />
        </template>
      </CWidgetStatsA>
    </CCol>

    <CCol :sm="6" :xl="4" :xxl="3">
      <CWidgetStatsA color="warning">
        <template #value>
          {{ currentWeek }} Bookings
          <span class="fs-6 fw-normal"> ({{ pctChange }}% <CIcon :icon="bookingIcon" />) </span>
        </template>
        <template #title
          >Weekly Pre-Booking
          <div>Previous Week: {{ prevWeek }} Bookings</div>
        </template>
        <template #action>
        </template>
        <template #chart>
          <CChart
            type="line"
            class="mt-3"
            style="height: 70px"
            :data="{
              labels: ['', '', '', '', '', '', ''],
              datasets: [
                {
                  label: '',
                  backgroundColor: 'rgba(255,255,255,.2)',
                  borderColor: 'rgba(255,255,255,.55)',
                  data: [78, 81, 80, 45, 34, 12, 40],
                  fill: true,
                },
              ],
            }"
            :options="{
              plugins: {
                legend: {
                  display: false,
                },
              },
              maintainAspectRatio: false,
              scales: {
                x: {
                  border: {
                    display: false,
                  },
                  display: false,
                },
                y: {
                  display: false,
                },
              },
              elements: {
                line: {
                  borderWidth: 2,
                  tension: 0.4,
                },
                point: {
                  radius: 0,
                  hitRadius: 10,
                  hoverRadius: 4,
                },
              },
            }"
          />
        </template>
      </CWidgetStatsA>
    </CCol>

    <!-- <CCol :sm="6" :xl="4" :xxl="3">
      <CWidgetStatsA color="danger">
        <template #value
          >2300
        </template>
        <template #title>Number of Active Users</template>
        <template #action>
        </template>
        <template #chart>
          <CChart
            type="bar"
            class="mt-3 mx-3"
            style="height: 70px"
            :data="{
              labels: [
                'January',
                'February',
                'March',
                'April',
                'May',
                'June',
                'July',
                'August',
                'September',
                'October',
                'November',
                'December',
                'January',
                'February',
                'March',
                'April',
              ],
              datasets: [
                {
                  label: 'My First dataset',
                  backgroundColor: 'rgba(255,255,255,.2)',
                  borderColor: 'rgba(255,255,255,.55)',
                  data: [
                    78, 81, 80, 45, 34, 12, 40, 85, 65, 23, 12, 98, 34, 84, 67,
                    82,
                  ],
                  barPercentage: 0.6,
                },
              ],
            }"
            :options="{
              maintainAspectRatio: false,
              plugins: {
                legend: {
                  display: false,
                },
              },
              scales: {
                x: {
                  grid: {
                    display: false,
                    drawTicks: false,
                  },
                  ticks: {
                    display: false,
                  },
                },
                y: {
                  border: {
                    display: false,
                  },
                  grid: {
                    display: false,
                    drawTicks: false,
                  },
                  ticks: {
                    display: false,
                  },
                },
              },
            }"
          />
        </template>
      </CWidgetStatsA>
    </CCol> -->
    <CCol :sm="6" :xl="4" :xxl="3">
      <CWidgetStatsA color="danger">
        <template #value>
          <!-- Bind the number of users dynamically -->
          {{ numberOfUsers }}
        </template>
        <template #title>Number of Active Users</template>
        <!-- date picker -->
        <template #action>
          <!-- Date Picker Input -->
          <CFormInput type="date" v-model="userSelectedDate" @change="fetchAllUserAnalytics" />
        </template>
        <template #chart>
          <CChart
            type="bar"
            class="mt-3 mx-3"
            style="height: 70px"
            :data="userChartData"
            :options="{
              maintainAspectRatio: false,
              plugins: {
                legend: {
                  display: false,
                },
              },
              scales: {
                x: {
                  grid: {
                    display: false,
                    drawTicks: false,
                  },
                  ticks: {
                    display: false,
                  },
                },
                y: {
                  beginAtZero: true,
                  grid: {
                    display: false,
                    drawTicks: false,
                  },
                  ticks: {
                    display: false,
                  },
                },
              },
            }"
          />
        </template>
      </CWidgetStatsA>
    </CCol>
  </CRow>
</template>

<script>
import axios from 'axios'
import { onMounted, ref, watch  } from 'vue'
import { CChart } from '@coreui/vue-chartjs'
import { getStyle } from '@coreui/utils'

export default {
  name: 'WidgetsStatsA',
  components: {
    CChart,
  },
  setup() {
    const widgetChartRef1 = ref()
    const widgetChartRef2 = ref()

    const revenue = ref(0) // This will hold the revenue for the selected date
    const revenueSelectedDate = ref(new Date().toISOString().split('T')[0]) // Today's date by default
    const revenueChartData = ref({
      labels: [],
      datasets: [
        {
          label: 'Daily Revenue',
          backgroundColor: '#f87979',
          data: [],
        },
      ],
    })

    // Function to fetch revenue for a single date
    const fetchRevenueForDate = async (date) => {
      try {
        const response = await axios.get(`http://54.193.153.2:8080/v1/analytics/revenue`, {
          params: { date },
        })
        // Update the revenue for the selected date
        if (date === revenueSelectedDate.value) {
          revenue.value = response.data.revenue || 0
        }
        return response.data.revenue || 0
      } catch (error) {
        console.error(`Error fetching revenue for date ${date}:`, error)
        // If the selected date fails to fetch, update revenue to 0
        if (date === revenueSelectedDate.value) {
          revenue.value = 0
        }
        return 0
      }
    }

    // Function to fetch and update the revenue data for the chart
    const fetchAllRevenueData = async () => {
      const datesToFetch = [
        // Fetching the last 10 days of data
        ...Array.from({ length: 10 })
          .map((_, i) => {
            let d = new Date()
            d.setDate(d.getDate() - i)
            return d.toISOString().split('T')[0]
          })
          .reverse(),
      ]

      const revenueData = await Promise.all(datesToFetch.map((date) => fetchRevenueForDate(date)))

      revenueChartData.value = {
        labels: datesToFetch,
        datasets: [
          {
            label: 'Daily Revenue',
            backgroundColor: '#f87979',
            data: revenueData,
          },
        ],
      }
    }

    const selectedLocation = ref('MarketMall') // Default location
    const parkingUtilization = ref(0) // This will hold the utilization percentage
    const parkingChartData = ref({
      labels: ['Parking Utilization'],
      datasets: [
        {
          label: 'Utilization Percentage',
          backgroundColor: 'rgba(0,123,255,.1)',
          borderColor: getStyle('--cui-info'),
          data: [0],
        },
      ],
    })

    const fetchParkingUtilization = async () => {
      try {
        const response = await axios.get(`http://54.193.153.2:8080/v1/analytics/parking`, {
          params: { location: selectedLocation.value },
        })
        const utilization = response.data[selectedLocation.value].pct_utilization || '0.00'
        parkingUtilization.value = parseFloat(utilization)
        parkingChartData.value.datasets[0].data = [parkingUtilization.value]
      } catch (error) {
        console.error(`Error fetching parking utilization for location ${selectedLocation.value}:`, error)
        parkingUtilization.value = 0
        parkingChartData.value.datasets[0].data = [0]
      }
    }

    // Watch for changes on selectedLocation and update the chart data
    watch(selectedLocation, () => {
      fetchParkingUtilization()
    })

    const numberOfUsers = ref(0)
    const userSelectedDate = ref(new Date().toISOString().split('T')[0]) // Today's date by default

    const userChartData = ref({
      labels: [],
      datasets: [
        {
          label: 'Number of Active Users',
          backgroundColor: '#f87979',
          data: [],
        },
      ],
    })

    const fetchUsersForDate = async (date) => {
      try {
        const response = await axios.get(`http://54.193.153.2:8080/v1/analytics/user`, {
          params: { date },
        })
        // Checking if the fetched date is the selected date and update numberOfUsers
        if (date === userSelectedDate.value) {
          numberOfUsers.value = response.data.no_of_users || 0
        }
        return response.data.no_of_users || 0
      } catch (error) {
        console.error(`Error fetching analytics for date ${date}:`, error)
        // If the selected date fails to fetch, updating numberOfUsers to 0
        if (date === userSelectedDate.value) {
          numberOfUsers.value = 0
        }
        return 0
      }
    }

    // Function to fetch and update the users data for the chart
    const fetchAllUserAnalytics = async () => {
      const datesToFetch = [
        // Fetching the last 10 days of data
        ...Array.from({ length: 10 })
          .map((_, i) => {
            let d = new Date()
            d.setDate(d.getDate() - i)
            return d.toISOString().split('T')[0]
          })
          .reverse(),
      ]

      const userCountsData = await Promise.all(datesToFetch.map((date) => fetchUsersForDate(date)))

      userChartData.value = {
        labels: datesToFetch,
        datasets: [
          {
            label: 'Number of Active Users',
            backgroundColor: '#f87979',
            data: userCountsData,
          },
        ],
      }
    }

    
    const currentWeek = ref(0)
    const prevWeek = ref(0)
    const pctChange = ref('')
    const bookingIcon = ref('cil-arrow-top') // Default icon

    const fetchBookingAnalytics = async () => {
      try {
        const response = await axios.get('http://54.193.153.2:8080/v1/analytics/booking', {
          params: { filter: 'weekly' },
        })
        currentWeek.value = response.data.current_week
        prevWeek.value = response.data.prev_week
        pctChange.value = response.data.pct_change

        // Manually determining the icon based on pctChange value
        bookingIcon.value = parseFloat(pctChange.value) < 0 ? 'cil-arrow-bottom' : 'cil-arrow-top'
      } catch (error) {
        console.error('Error fetching booking analytics:', error)
        // Reset values if there's an error
        currentWeek.value = 0
        prevWeek.value = 0
        pctChange.value = '0'
        bookingIcon.value = 'cil-arrow-top'
      }
    }

    fetchBookingAnalytics()

    onMounted(() => {
      fetchAllUserAnalytics()
      fetchAllRevenueData()
      fetchParkingUtilization()
      document.documentElement.addEventListener('ColorSchemeChange', () => {
        if (widgetChartRef1.value) {
          widgetChartRef1.value.chart.data.datasets[0].pointBackgroundColor =
            getStyle('--cui-primary')
          widgetChartRef1.value.chart.update()
        }

        if (widgetChartRef2.value) {
          widgetChartRef2.value.chart.data.datasets[0].pointBackgroundColor = getStyle('--cui-info')
          widgetChartRef2.value.chart.update()
        }
      })
    })

    return {
      getStyle,
      widgetChartRef1,
      widgetChartRef2,
      revenue,
      revenueSelectedDate,
      revenueChartData,
      fetchAllRevenueData,
      parkingChartData,
      parkingUtilization,
      selectedLocation,
      fetchParkingUtilization,
      numberOfUsers,
      userSelectedDate,
      fetchAllUserAnalytics,
      userChartData,
      currentWeek,
      prevWeek,
      pctChange,
      fetchBookingAnalytics,
      bookingIcon,
    }
  },
}
</script>
