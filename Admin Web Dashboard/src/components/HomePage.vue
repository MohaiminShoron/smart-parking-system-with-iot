<template>
  <!-- Main container for the home page -->
  <div class="home-container">
    <div class="card home-card">
      <div class="card-body">
        <h2 class="card-title text-center mb-4">
          Welcome to the Admin Portal
        </h2>
        <p class="card-text text-center">
          Check out the Dashboard and Analytics!
        </p>
        <div class="d-grid gap-2 col-6 mx-auto">
          <!-- Navigation link to the pages -->
          <router-link to="/dashboard" class="btn btn-primary btn-lg"
            >Dashboard</router-link
          >
          <router-link to="/analytics" class="btn btn-primary btn-lg"
            >Analytics</router-link
          >
          <button @click="logoutUser" class="btn btn-secondary btn-lg">
            Logout
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  //lifecycle hook triggered when the component is created
  created() {
    // Check if user is logged in
    if (!localStorage.getItem("token")) {
      // User is not logged in, redirect to login page
      this.$router.push("/login");
    }
  },
  methods: {
    logoutUser() {
      // Dispatch the logout action defined in Vuex store
      this.$store.dispatch("logoutUser");
      // Redirect to login page after logout
      this.$router.push("/login");
    },
    goToCategories() {
      this.$router.push("/categories"); // Navigate to categories page
    },
  },
};
</script>

<style scoped>
.home-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  min-height: 100vh;
  background-image: url("~@/assets/background.jpg");
  background-size: cover;
  background-position: center;
}

.home-card {
  width: 100%;
  max-width: 600px; /* Adjusted max-width to make the card wider */
  background-color: rgba(255, 255, 255, 0.9);
  border-radius: 15px;
  padding: 2rem;
  box-shadow: 0 5px 15px rgba(0, 0, 0, 0.2);
  margin: auto; /* Added to center the card horizontally */
}

.card-title {
  font-size: 2rem;
  color: var(--bs-primary);
  margin-bottom: 1rem;
}
.card-text {
  font-size: 1.25rem;
  color: var(--bs-secondary);
  margin-bottom: 1.5rem;
}
.btn-primary {
  background-color: #007bff;
  border-color: #007bff;
}

.btn-primary:hover {
  background-color: #0056b3;
  border-color: #0056b3;
}

.btn-secondary {
  background-color: #6c757d;
  border-color: #6c757d;
}

.btn-secondary:hover {
  background-color: #545b62;
  border-color: #545b62;
}
.btn-lg {
  font-size: 1rem;
  padding: 0.5rem 1rem;
}

.d-grid {
  max-width: none;
}
</style>
