<template>
  <div>
    <section class="content-header">
      <div class="container">
        <div class="row mb-5">
          <div class="col-sm-6">
            <h1>Detail Kartu Keluarga</h1>
          </div>
        </div>
        <app-success v-show="success" />
        <div v-show="!success">
          <div class="">
            <router-link to="/home" type="submit" class="btn btn-info mr-3"
              >Back</router-link
            >
            <button
              v-show="!update"
              @click="updateButton"
              type="submit"
              class="btn btn-warning mx-5 text-white"
            >
              Update Kartu Keluarga
            </button>
            <router-link
              :to="{
                name: 'ListAnggota',
              }"
              type="submit"
              class="btn btn-primary"
              >Lihat Anggota Keluarga</router-link
            >
          </div>
          <form
            action=""
            class="border p-5 my-5"
            style="background-color: white"
          >
            <div class="row d-flex justify-content-between">
              <div class="col-6">
                <div class="form-group row">
                  <label for="nomor_kk" class="col-md-6 col-sm-2 col-form-label"
                    >Nomor Kartu Keluarga</label
                  >
                  <div class="col-md-6 col-sm-10">
                    <input
                      :disabled="isDisabled"
                      v-model="dataKK.nomor_kk"
                      type="number"
                      class="form-control"
                      id="nomor_kk"
                      placeholder="Nomor Kartu Keluarga"
                    />
                  </div>
                </div>
                <div class="form-group row">
                  <label for="alamat" class="col-md-6 col-sm-2 col-form-label"
                    >Alamat</label
                  >
                  <div class="col-md-6 col-sm-10">
                    <textarea
                      v-model="dataKK.alamat"
                      :disabled="isDisabled"
                      name="alamat"
                      id="alamat"
                      class="form-control"
                      rows="3"
                      placeholder="Alamat Lengkap"
                    ></textarea>
                  </div>
                </div>
                <div class="form-group row">
                  <label for="rt" class="col-md-6 col-sm-2 col-form-label"
                    >RT</label
                  >
                  <div class="col-md-6 col-sm-10">
                    <input
                      v-model="dataKK.rt"
                      :disabled="isDisabled"
                      type="number"
                      class="form-control"
                      id="rt"
                      placeholder="RT"
                    />
                  </div>
                </div>
                <div class="form-group row">
                  <label for="rw" class="col-md-6 col-sm-2 col-form-label"
                    >RW</label
                  >
                  <div class="col-md-6 col-sm-10">
                    <input
                      v-model="dataKK.rw"
                      :disabled="isDisabled"
                      type="number"
                      class="form-control"
                      id="rw"
                      placeholder="RW"
                    />
                  </div>
                </div>
              </div>
              <div class="col-6">
                <div class="form-group row">
                  <label
                    for="desa_kelurahan"
                    class="col-md-6 col-sm-2 col-form-label"
                    >Desa / Kelurahan</label
                  >
                  <div class="col-md-6 col-sm-10">
                    <input
                      v-model="dataKK.desa_kelurahan"
                      :disabled="isDisabled"
                      type="text"
                      class="form-control"
                      id="desa_kelurahan"
                      placeholder="Desa / Kelurahan"
                    />
                  </div>
                </div>
                <div class="form-group row">
                  <label
                    for="kecamatan"
                    class="col-md-6 col-sm-2 col-form-label"
                    >Kecamatan</label
                  >
                  <div class="col-md-6 col-sm-10">
                    <input
                      v-model="dataKK.kecamatan"
                      :disabled="isDisabled"
                      type="text"
                      class="form-control"
                      id="kecamatan"
                      placeholder="Kecamatan"
                    />
                  </div>
                </div>
                <div class="form-group row">
                  <label
                    for="kabupaten_kota"
                    class="col-md-6 col-sm-2 col-form-label"
                    >Kabupaten / Kota</label
                  >
                  <div class="col-md-6 col-sm-10">
                    <input
                      v-model="dataKK.kabupaten_kota"
                      :disabled="isDisabled"
                      type="text"
                      class="form-control"
                      id="kabupaten_kota"
                      placeholder="Kabupaten / Kota"
                    />
                  </div>
                </div>
                <div class="form-group row">
                  <label for="provinsi" class="col-md-6 col-sm-2 col-form-label"
                    >Provinsi</label
                  >
                  <div class="col-md-6 col-sm-10">
                    <input
                      v-model="dataKK.provinsi"
                      :disabled="isDisabled"
                      type="text"
                      class="form-control"
                      id="provinsi"
                      placeholder="Provinsi"
                    />
                  </div>
                </div>
                <div class="form-group row">
                  <label for="kode_pos" class="col-md-6 col-sm-2 col-form-label"
                    >Kode Pos</label
                  >
                  <div class="col-md-6 col-sm-10">
                    <input
                      v-model="dataKK.kode_pos"
                      :disabled="isDisabled"
                      type="number"
                      class="form-control"
                      id="kode_pos"
                      placeholder="Kode Pos"
                    />
                  </div>
                </div>
              </div>
            </div>
            <p class="text-danger" v-if="validNoKK">Nomor KK Sudah digunakan</p>
            <div class="button-update" v-show="update">
              <button
                type="submit"
                class="btn btn-danger mt-5 mr-2"
                @click.prevent="cancelUpdate"
              >
                Cancel
              </button>
              <button
                type="submit"
                class="btn btn-success mt-5"
                @click.prevent="updateKK"
              >
                Update
              </button>
            </div>
          </form>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import kartuKeluargaService from "@/services/ektpService";
export default {
  name: "DetailView",
  data() {
    return {
      dataKK: {
        nomor_kk: null,
        alamat: null,
        rt: null,
        rw: null,
        desa_kelurahan: null,
        kecamatan: null,
        kabupaten_kota: null,
        provinsi: null,
        kode_pos: null,
      },
      success: false,
      update: false,
      isDisabled: true,
      validNoKK: false
    };
  },
  methods: {
    getKK() {
      let id = this.$route.params.id;
      kartuKeluargaService
        .getKK(id)
        .then((response) => {
          this.dataKK = response.data;
          console.log(this.dataKK);
        })
        .catch((e) => {
          console.log(e);
        });
    },

    updateKK() {
      let data = this.dataKK;
      let id = this.$route.params.id;
      kartuKeluargaService
        .updateKK(id, data)
        .then((response) => {
          this.dataKK = response.data;
          console.log(this.dataKK);
          this.success = true;
        })
        .catch((e) => {
          console.log(e);
          this.validNoKK = true;
        });
    },

    updateButton() {
      this.update = true;
      this.isDisabled = false;
    },

    cancelUpdate() {
      location.reload();
    },
  },

  mounted() {
    this.getKK();
  },
};
</script>

<style>
</style>