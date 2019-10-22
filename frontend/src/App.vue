<template>
  <div id="app">
    <Header></Header>
    <HelloWorld msg="Welcome to Your Vue.js App"/>
    <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full">
      <a href="https://lab.ssafy.com/oauth/authorize?client_id=95d63ca25200e7d735fd3856c1e9907b5dfd0926246b44653aa7cffc1d8bc832&redirect_uri=http%3A%2F%2Flocalhost:8080&response_type=code&scope=read_user">
        인증하기
      </a>
    </button>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import Header from './components/Header.vue'
import './assets/css/output.css'

export default {
  name: 'app',
  components: {
    HelloWorld,
    Header
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
