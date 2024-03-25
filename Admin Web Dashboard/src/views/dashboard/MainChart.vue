<template>
  <CChart type="line" :data="chartData" :options="options" ref="mainChartRef" />
</template>

<script>
// import axios from 'axios'
import { ref, watch } from 'vue'
import { CChart } from '@coreui/vue-chartjs'
import { getStyle } from '@coreui/utils'

// const random = (min, max) => Math.floor(Math.random() * (max - min + 1) + min)

export default {
  name: 'MainChartExample',
  components: {
    CChart,
  },
  props: {
    bookingData: Object
  },
  setup(props) {
    const mainChartRef = ref(null)
    // const data = {
    //   labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
    //   datasets: [
    //     {
    //       label: 'My First dataset',
    //       backgroundColor: `rgba(${getStyle('--cui-info-rgb')}, .1)`,
    //       borderColor: getStyle('--cui-info'),
    //       pointHoverBackgroundColor: getStyle('--cui-info'),
    //       borderWidth: 2,
    //       data: [
    //         random(50, 200),
    //         random(50, 200),
    //         random(50, 200),
    //         random(50, 200),
    //         random(50, 200),
    //         random(50, 200),
    //         random(50, 200),
    //       ],
    //       fill: true,
    //     },
    //     {
    //       label: 'My Second dataset',
    //       backgroundColor: 'transparent',
    //       borderColor: getStyle('--cui-success'),
    //       pointHoverBackgroundColor: getStyle('--cui-success'),
    //       borderWidth: 2,
    //       data: [
    //         random(50, 200),
    //         random(50, 200),
    //         random(50, 200),
    //         random(50, 200),
    //         random(50, 200),
    //         random(50, 200),
    //         random(50, 200),
    //       ],
    //     },
    //     {
    //       label: 'My Third dataset',
    //       backgroundColor: 'transparent',
    //       borderColor: getStyle('--cui-danger'),
    //       pointHoverBackgroundColor: getStyle('--cui-danger'),
    //       borderWidth: 1,
    //       borderDash: [8, 5],
    //       data: [65, 65, 65, 65, 65, 65, 65],
    //     },
    //   ],
    // }

    // const data = ref({
    //   labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
    //   datasets: [
    //     {
    //       label: 'My First dataset',
    //       backgroundColor: `rgba(${getStyle('--cui-info-rgb')}, .1)`,
    //       borderColor: getStyle('--cui-info'),
    //       pointHoverBackgroundColor: getStyle('--cui-info'),
    //       borderWidth: 2,
    //       data: [], 
    //       fill: true,
    //     },
    //   ],
    // });

    const options = ({
      maintainAspectRatio: false,
      plugins: {
        legend: {
          display: false,
        },
      },
      scales: {
        x: {
          grid: {
            color: getStyle('--cui-border-color-translucent'),
            drawOnChartArea: false,
          },
          ticks: {
            color: getStyle('--cui-body-color'),
          },
        },
        y: {
          beginAtZero: true,
          border: {
            color: getStyle('--cui-border-color-translucent'),
          },
          grid: {
            color: getStyle('--cui-border-color-translucent'),
          },
          max: 50,
          ticks: {
            color: getStyle('--cui-body-color'),
            maxTicksLimit: 5,
            stepSize: Math.ceil(250 / 5),
          },
        },
      },
      elements: {
        line: {
          tension: 0.4,
        },
        point: {
          radius: 0,
          hitRadius: 10,
          hoverRadius: 4,
          hoverBorderWidth: 3,
        },
      },
    })

    const formatChartData = (bookingData) => {
      const labels = Object.keys(bookingData);
      const data = Object.values(bookingData);

      return {
        labels,
        datasets: [
          {
            label: 'Bookings',
            backgroundColor: 'rgba(0,123,255,0.5)',
            borderColor: 'rgba(0,123,255,1)',
            pointHoverBackgroundColor: '#fff',
            borderWidth: 1.5,
            data,
          },
        ],
      };
    };

    const chartData = ref(formatChartData(props.bookingData));

    // const fetchMonthlyBookingAnalytics = async () => {
    //   try {
    //     const response = await axios.get(`http://50.18.14.138:8080/v1/analytics/booking`, {
    //       params: {
    //         year: 2023,
    //         filter: 'monthly'
    //       }
    //     });
    //     const bookingsData = response.data;
    //     data.value.labels = Object.keys(bookingsData);
    //     data.value.datasets[0].data = Object.values(bookingsData);
    //   } catch (error) {
    //     console.error('Error fetching monthly booking analytics:', error);
    //   }
    // };

    watch(() => props.bookingData, (newData) => {
      chartData.value = formatChartData(newData);
    }, {
      deep: true,
      immediate: true,
    });

    // onMounted(() => {
    //   fetchMonthlyBookingAnalytics();
    // })

    return {
      // data,
      mainChartRef,
      options,
      chartData
    }
  },
}
</script>
