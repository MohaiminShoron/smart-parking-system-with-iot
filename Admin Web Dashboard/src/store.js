import { createStore } from 'vuex';

export default createStore({
   // The state is a function that returns an object where you can define all the state properties
  state() {
    return {
      userId: null, // Holds the ID of the logged-in user
      email: null, // Holds the email of the logged-in user
    };
  },
   // Mutations are functions that affect the state. They are the only way to change state in Vuex
  mutations: {
    // Sets the user details in the state
    setUser(state, { userId, email }) {
      state.userId = userId;
      state.email = email;
    },
    // Clears the user details from the state
    clearUser(state) {
      state.userId = null;
      state.email = null;
    },
  },
  // Similar to mutations, but they can contain asynchronous operations
  actions: {
    // Logs in the user by committing the setUser mutation
    loginUser({ commit }, { userId, email }) {
      commit('setUser', { userId, email });
    },
    // Logs out the user by committing the clearUser mutation and removing the token from localStorage
    logoutUser({ commit }) {
      commit('clearUser');
      localStorage.removeItem('token'); // Removes the 'token' from the local storage
    },
  },
   // Getters are like computed properties for stores and can be used to compute derived state
  getters: {
    isLoggedIn: state => !!state.userId, // Returns true if the user is logged in (i.e., userId is not null)
  },
});
