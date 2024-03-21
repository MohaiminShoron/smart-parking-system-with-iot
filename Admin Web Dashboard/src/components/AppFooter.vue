<template>
  <CFooter class="px-4">
    <div>
      <a href="https://coreui.io" target="_blank">Smart Parking System</a>
      <span class="ms-1"
        >&copy; {{ new Date().getFullYear() }} </span
      >
    </div>
    <div class="ms-auto">
      <span class="me-1" target="_blank">Powered by</span>
      <a href="https://coreui.io/vue">Group 18</a>
    </div>
  </CFooter>
</template>

<script>
export default {
  name: 'AppFooter',
}
</script>
