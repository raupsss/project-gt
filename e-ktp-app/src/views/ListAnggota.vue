<template>
  <div>
    <section class="content-header">
      <div class="container">
        <div class="row mb-5">
          <div class="col-sm-6">
            <h1>Anggota Keluarga</h1>
          </div>
        </div>
        <app-success v-show="success" />
        <div v-show="!success">
          <!-- DISINI -->
          <button @click="back" type="submit" class="btn btn-info mr-2">
            Back
          </button>
          <button
            type="submit"
            class="btn btn-primary"
            v-show="isDisplay"
            @click.prevent="tambahAnggotaFunc"
          >
            Tambah Anggota Keluarga
          </button>
          <table
            v-show="isDisplay"
            class="
              table table-striped table-hover
              bg-white
              border border-rounded
              mt-5
            "
          >
            <thead>
              <tr>
                <th scope="col">No</th>
                <th scope="col">NIK</th>
                <th scope="col">Nama</th>
                <th scope="col">Jenis Kelamin</th>
                <th scope="col">Kepala Keluarga</th>
                <th scope="col">Aksi</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="(item, index) in dataAnggota" :key="index">
                <th scope="row">{{ (index += 1) }}</th>
                <td>{{ item.nik }}</td>
                <td>{{ item.nama }}</td>
                <td>{{ item.jenis_kelamin }}</td>
                <td>{{ item.kepala_keluarga }}</td>
                <td>
                  <router-link
                    :to="{
                      name: 'DetailAnggota',
                      params: { idAnggota: item.id },
                    }"
                    type="submit"
                    class="btn btn-warning mr-1 text-white"
                  >
                    Detail
                  </router-link>
                  <button
                    type="submit"
                    class="btn btn-danger"
                    @click.prevent="deleteAnggota(item.id, item.nama)"
                  >
                    Hapus
                  </button>
                </td>
              </tr>
              <tr>
                <td colspan="6" v-if="dataAnggota.length == 0">
                  <h1 class="text-center">Data Kosong</h1>
                </td>
              </tr>
            </tbody>
          </table>

          <!-- FORM TAMBAH ANGGOTA -->
          <form
            v-show="!isDisplay"
            @submit.prevent="addAnggota"
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
            <button type="submit" class="btn btn-success mt-5" @click="addIdKK">
              Submit
            </button>
          </form>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import anggotaService from "@/services/ektpService";

export default {
  name: "ListAnggota",
  data() {
    return {
      dataAnggota: [],
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
      isDisplay: true,
      success: false,
      validNIK: false,
    };
  },

  methods: {
    getAllAnggota() {
      anggotaService.getAllAnggota().then((response) => {
        this.dataAnggota = response.data;
        console.log(this.dataAnggota);
      });
    },

    getIdKK(id) {
      anggotaService.getIdKK(id).then((response) => {
        this.dataAnggota = response.data;
        console.log(this.dataAnggota);
      });
    },

    tambahAnggotaFunc() {
      this.isDisplay = false;
    },

    addAnggota() {
      let data = this.dataTambahAnggota;
      anggotaService
        .addAnggota(data)
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

    addIdKK() {
      this.dataTambahAnggota.id_kk = this.$route.params.id;
    },

    back() {
      window.history.back();
    },

    deleteAnggota(id, nama) {
      this.$confirm(`Apakah Anda ingin menghapus ${nama} dari Anggota Kelaurga ?`).then(() => {

        anggotaService
          .deleteAnggota(id)
          .then((response) => {
            console.log(response.data);
            location.reload();
          })
          .catch((e) => {
            console.log(e);
          });
      })
    },
  },

  mounted() {
    if (this.$route.name == "ListAnggota") {
      this.getIdKK(this.$route.params.id);
    }
  },
};
</script>

<style>
</style>