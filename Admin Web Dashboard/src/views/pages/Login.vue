<template>
  <div class="bg-body-tertiary min-vh-100 d-flex flex-row align-items-center">
    <CContainer>
      <CRow class="justify-content-center">
        <CCol :md="8">
          <CCardGroup>
            <CCard class="p-4">
              <CCardBody>
                <CForm @submit.prevent="handleLogin">
                  <h1>Login</h1>
                  <p class="text-body-secondary">Sign In to your account</p>
                  <CInputGroup class="mb-3">
                    <CInputGroupText>
                      <CIcon icon="cil-user" />
                    </CInputGroupText>
                    <CFormInput
                      placeholder="Email"
                      v-model="loginDetails.email"
                    />
                  </CInputGroup>
                  <CInputGroup class="mb-4">
                    <CInputGroupText>
                      <CIcon icon="cil-lock-locked" />
                    </CInputGroupText>
                    <CFormInput
                      type="password"
                      placeholder="Password"
                      v-model="loginDetails.password"
                    />
                  </CInputGroup>
                  <CRow>
                    <CCol :xs="6">
                      <CButton type="submit" color="primary" class="px-4"> Login </CButton>
                    </CCol>
                  </CRow>
                </CForm>
              </CCardBody>
            </CCard>
            <CCard class="text-white bg-primary py-5" style="width: 44%">
              <CCardBody class="text-center">
                <div>
                  <h2>Sign up</h2>
                  <p>
                    Create an account to login to the Admin Portal
                  </p>
                  <CButton color="light" variant="outline" class="mt-3" @click="goToRegister">
                    Register Now!
                  </CButton>
                </div>
              </CCardBody>
            </CCard>
          </CCardGroup>
        </CCol>
      </CRow>
    </CContainer>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'Login',
  data() {
    return {
      loginDetails: {
        email: '',
        password: '',
      },
      loginError: null, //To track login errors
    };
  },
  methods: {
    async handleLogin() {
      this.loginError = null; // Reset login error before attempting
      try {
        const response = await axios.post('http://localhost:8081/smart-parking-0.0.1-SNAPSHOT/api/login', this.loginDetails);
        // Handle your response here. Example: save the token, redirect, etc.
        console.log(response.data);
        // Redirect to dashboard or somewhere else upon successful login
        this.$router.push('/dashboard');
      } catch (error) {
        this.loginError = "Incorrect email or password.";
        console.error(error.response.data); // Log the error response from the server
        alert(this.loginError); 
      }
    },
    goToRegister() {
      // Use Vue Router's push method to navigate to the "/register" route
      this.$router.push('/register');
    }
  }
}
</script>
