<template>
  <div class="bg-body-tertiary min-vh-100 d-flex flex-row align-items-center">
    <CContainer>
      <CRow class="justify-content-center">
        <CCol :md="9" :lg="7" :xl="6">
          <CCard class="mx-4">
            <CCardBody class="p-4">
              <CForm @submit.prevent="registerUser">
                <h1>Register</h1>
                <p class="text-body-secondary">Create your account</p>
                <CInputGroup class="mb-3">
                  <CInputGroupText>
                    <CIcon icon="cil-user" />
                  </CInputGroupText>
                  <CFormInput placeholder="Full Name" v-model="fullName"/>
                </CInputGroup>
                <CInputGroup class="mb-3">
                  <CInputGroupText>@</CInputGroupText>
                  <CFormInput placeholder="Email" v-model="email" />
                </CInputGroup>
                <CInputGroup class="mb-3">
                  <CInputGroupText>
                    <CIcon icon="cil-lock-locked" />
                  </CInputGroupText>
                  <CFormInput
                    type="phone"
                    placeholder="Phone"
                    v-model="phone"
                  />
                </CInputGroup>
                <CInputGroup class="mb-4">
                  <CInputGroupText>
                    <CIcon icon="cil-lock-locked" />
                  </CInputGroupText>
                  <CFormInput
                    type="password"
                    placeholder="Password"
                    v-model="password"
                  />
                </CInputGroup>
                <div class="d-grid">
                  <CButton color="success" type="submit">Create Account</CButton>
                </div>
              </CForm>
            </CCardBody>
          </CCard>
        </CCol>
      </CRow>
    </CContainer>
  </div>
</template>

<script>
import axios from 'axios'; 

export default {
  name: 'Register',
  data() {
    return {
      // Initialize data properties
      intent: "web",
      fullName: '',
      email: '',
      phone: '',
      password: '',
    };
  },
  methods: {
    registerUser() {
      axios.post('http://localhost:8081/smart-parking-0.0.1-SNAPSHOT/api/register', {
          intent: "web",
          fullName: this.fullName,
          email: this.email,
          phone: this.phone,
          password: this.password,
        })
        .then((response) => {
          console.log("response: ", response);
          alert("Registration successful!");
          this.$router.push("/login");
        })
        .catch((error) => {
          console.log("error: ", error);
          // Check if the error response has data and a message
          const message = error.response && error.response.data && error.response.data.message 
                          ? error.response.data.message 
                          : "Something went wrong. Please try again.";
          alert(message);
        });
    },
  },
};

</script>
