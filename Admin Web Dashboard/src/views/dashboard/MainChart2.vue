<template>
  <CChart type="line" :data="chartData" :options="options" ref="mainChartRef2" />
</template>

<script>
import { ref, watch } from 'vue'
import { CChart } from '@coreui/vue-chartjs'
import { getStyle } from '@coreui/utils'

export default {
  name: 'MainChart2',
  components: {
    CChart,
  },
  props: {
    userData: Object,
  },
  setup(props) {
    const mainChartRef2 = ref(null)

    const options = {
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
    }

    const formatChartData = (userData) => {
      const labels = Object.keys(userData)
      const data = Object.values(userData)

      return {
        labels,
        datasets: [
          {
            label: 'Active Users',
            backgroundColor: 'rgba(0,123,255,0.5)',
            borderColor: 'rgba(0,123,255,1)',
            pointHoverBackgroundColor: '#fff',
            borderWidth: 1.5,
            data,
          },
        ],
      }
    }

    const chartData = ref(formatChartData(props.userData))

    watch(
      () => props.userData,
      (newData) => {
        chartData.value = formatChartData(newData)
      },
      {
        deep: true,
        immediate: true,
      },
    )

    return {
      mainChartRef2,
      options,
      chartData,
    }
  },
}
</script>
