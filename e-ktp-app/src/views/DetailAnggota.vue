<template>
  <div>
    <section class="content-header">
      <div class="container">
        <div class="row mb-5">
          <div class="col-sm-6">
            <h1>Detail Anggota Keluarga</h1>
          </div>
        </div>
        <app-success v-show="success" />
        <div v-show="!success">
          <button type="submit" class="btn btn-info mr-3" @click="back">
            Back
          </button>
          <button
            type="submit"
            class="btn btn-warning text-white"
            @click.prevent="updateButton"
            v-show="!update"
          >
            Update Anggota
          </button>
          <form
            @submit.prevent="updateAnggota"
            action=""
            class="border p-5 my-5"
            style="background-color: white"
          >
            <div class="row d-flex justify-content-between">
              <div class="col-6">
                <div class="form-group row">
                  <label for="nik" class="col-md-6 col-sm-2 col-form-label"
                    >NIK</label
                  >
                  <div class="col-md-6 col-sm-10">
                    <input
                      :disabled="isDisabled"
                      v-model="dataTambahAnggota.nik"
                      type="number"
                      class="form-control"
                      id="nik"
                      placeholder="NIK"
                    />
                  </div>
                </div>
                <div class="form-group row">
                  <label for="nama" class="col-md-6 col-sm-2 col-form-label"
                    >Nama</label
                  >
                  <div class="col-md-6 col-sm-10">
                    <input
                      :disabled="isDisabled"
                      v-model="dataTambahAnggota.nama"
                      type="text"
                      class="form-control"
                      id="nama"
                      placeholder="Nama Lengkap"
                    />
                  </div>
                </div>
                <div class="form-group row">
                  <label
                    for="jenis_kelamin"
                    class="col-md-6 col-sm-2 col-form-label"
                    >Jenis Kelamin</label
                  >
                  <div class="col-md-6 col-sm-10">
                    <select
                      :disabled="isDisabled"
                      v-model="dataTambahAnggota.jenis_kelamin"
                      name="jenis_kelamin"
                      id="jenis_kelamin"
                      class="form-control"
                    >
                      <option selected disabled value=""></option>
                      <option>Pria</option>
                      <option>Wanita</option>
                    </select>
                  </div>
                </div>
                <div class="form-group row">
                  <label
                    for="tempat_lahir"
                    class="col-md-6 col-sm-2 col-form-label"
                    >Tempat Lahir</label
                  >
                  <div class="col-md-6 col-sm-10">
                    <input
                      :disabled="isDisabled"
                      v-model="dataTambahAnggota.tempat_lahir"
                      type="text"
                      class="form-control"
                      id="tempat_lahir"
                      placeholder="Tempat Lahir"
                    />
                  </div>
                </div>
              </div>
              <div class="col-6">
                <div class="form-group row">
                  <label
                    for="tanggal_lahir"
                    class="col-md-6 col-sm-2 col-form-label"
                    >Tanggal Lahir</label
                  >
                  <div class="col-md-6 col-sm-10">
                    <input
                      :disabled="isDisabled"
                      v-model="dataTambahAnggota.tanggal_lahir"
                      type="date"
                      class="form-control"
                      id="tanggal_lahir"
                      placeholder="Tanggal Lahir"
                    />
                  </div>
                </div>
                <div class="form-group row">
                  <label for="agama" class="col-md-6 col-sm-2 col-form-label"
                    >Agama</label
                  >
                  <div class="col-md-6 col-sm-10">
                    <input
                      :disabled="isDisabled"
                      v-model="dataTambahAnggota.agama"
                      type="text"
                      class="form-control"
                      id="agama"
                      placeholder="Agama"
                    />
                  </div>
                </div>
                <div class="form-group row">
                  <label
                    for="pendidikan"
                    class="col-md-6 col-sm-2 col-form-label"
                    >Pendidikan</label
                  >
                  <div class="col-md-6 col-sm-10">
                    <input
                      :disabled="isDisabled"
                      v-model="dataTambahAnggota.pendidikan"
                      type="text"
                      class="form-control"
                      id="pendidikan"
                      placeholder="Pendidikan Terakhir"
                    />
                  </div>
                </div>
                <div class="form-group row">
                  <label
                    for="kepala_keluarga"
                    class="col-md-6 col-sm-2 col-form-label"
                    >Kepala Keluarga</label
                  >
                  <div class="col-md-6 col-sm-10">
                    <select
                      :disabled="isDisabled"
                      v-model="dataTambahAnggota.kepala_keluarga"
                      name="kepala_keluarga"
                      id="kepala_keluarga"
                      class="form-control"
                    >
                      <option selected disabled value=""></option>
                      <option>Yes</option>
                      <option>No</option>
                    </select>
                  </div>
                </div>
              </div>
            </div>
            <p class="text-danger" v-if="validNIK">NIK Sudah digunakan</p>
            <div v-show="update">
              <button
                type="submit"
                class="btn btn-danger mt-5 mr-2"
                @click.prevent="cancelUpdate"
              >
                Cancel
              </button>
              <button type="submit" class="btn btn-success mt-5">Update</button>
            </div>
          </form>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import anggotaService from "../services/ektpService";
export default {
  nama: "DetailAnggota",

  data() {
    return {
      dataTambahAnggota: {
        agama: null,
        id_kk: null,
        jenis_kelamin: null,
        kepala_keluarga: null,
        nama: null,
        nik: null,
        pendidikan: null,
        tanggal_lahir: null,
        tempat_lahir: null,
      },
      success: false,
      update: false,
      isDisabled: true,
      validNIK : false
    };
  },

  methods: {
    back() {
      window.history.back();
    },

    updateButton() {
      this.isDisabled = false;
      this.update = true;
    },

    cancelUpdate() {
      location.reload();
    },

    getAnggota() {
      let id = this.$route.params.idAnggota;
      anggotaService
        .getAnggota(id)
        .then((response) => {
          this.dataTambahAnggota = response.data;
          console.log(this.dataTambahAnggota);
        })
        .catch((e) => {
          console.log(e);
        });
    },

    updateAnggota() {
      let data = this.dataTambahAnggota;
      let id = this.$route.params.idAnggota;

      anggotaService
        .updateAnggota(id, data)
        .then((response) => {
          this.dataTambahAnggota = response.data;
          console.log(this.dataTambahAnggota);
          this.success = true;
        })
        .catch((e) => {
          console.log(e);
          this.validNIK = true;
        });
    },
  },
  mounted() {
    this.getAnggota();
  },
};
</script>

<style>
</style>