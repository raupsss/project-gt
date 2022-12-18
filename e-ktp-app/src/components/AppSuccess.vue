<template>
  <div>
    <div class="row justify-content-center my-5 ">
      <div class="card-body border col-6 successForm">
        <h5 class="card-title font-weight-bold">Selamat !</h5>
        <p class="card-text">
          Data berhasil di
          <strong>{{ message }}</strong>
        </p>
        <button
          class="btn btn-primary"
          @click="reloadPage"
          v-if="message == 'Kirim!'"
        >
          Close
        </button>
        <button
          class="btn btn-primary"
          @click="back"
          v-else-if="message == 'Hapus!'"
        >
          Back
        </button>
        <button v-else class="btn btn-primary" @click="reloadPage">
          Close
        </button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "AppSuccess",
  data() {
    return {
      message: null,
    };
  },

  methods: {
    changeMessage() {
      let route = this.$route.name;
      if (route === "HomePage" || route === "ListAnggota" || route === "AddPage") {
        this.message = "Kirim!";
      } else if (route === "HomePage") {
        this.message = "Hapus!";
      } else if(route === "LoginPage") {
        this.message = "Daftar!";
      }
      else {
        this.message = "Perbarui!";
      }
    },
    reloadPage() {
      location.reload();
    },
    back() {
      window.history.back();
    },
  },

  mounted() {
    this.changeMessage();
  },
};
</script>

<style lang="scss" scoped>

.successForm {
background-color: #eff5f5;
}


</style>
