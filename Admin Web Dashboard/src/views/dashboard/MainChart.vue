<template>
  <CChart type="line" :data="chartData" :options="options" ref="mainChartRef" />
</template>

<script>
import { ref, watch } from 'vue'
import { CChart } from '@coreui/vue-chartjs'
import { getStyle } from '@coreui/utils'

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
          max: 100,
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

    watch(() => props.bookingData, (newData) => {
      chartData.value = formatChartData(newData);
    }, {
      deep: true,
      immediate: true,
    });

    return {
      mainChartRef,
      options,
      chartData
    }
  },
}
</script>
