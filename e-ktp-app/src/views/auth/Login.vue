<template>
  <body>
    <div class="container">
      <app-success v-show="success"/>
      <div v-show="!success">
      <input type="checkbox" id="flip" />
      <div class="cover">
        <div class="front">
          <img src="@/assets/ktp.png" alt="" />
        </div>
        <div class="back">
          <img class="backImg" src="@/assets/ktp.png" alt="" />
        </div>
      </div>
      <div class="forms">
        <div class="form-content">
          <div class="login-form">
            <div class="title">Selamat Datang</div>
            <form @submit.prevent="login">
              <div class="input-boxes">
                <div class="input-box">
                  <input v-model="dataLogin.email" type="email" placeholder="Email" required />
                </div>
                <div class="input-box">
                  <input v-model="dataLogin.password" type="password" placeholder="Password" required />
                </div>
                <p class="text-danger mt-2" v-if="loginValid">Email atau Password Salah !</p>
                <button
                  type="submit"
                  class="btn btn-primary w-100 mt-4"
                >
                  Masuk
                </button>
                <div class="text sign-up-text">
                  Tidak memiliki akun ? <label for="flip">Daftar</label>
                </div>
              </div>
            </form>
          </div>
          <div class="signup-form">
            <div class="title">Daftar</div>
            <form @submit.prevent="register">
              <div class="input-boxes">
                <div class="input-box">
                  <input v-model="dataRegister.nama" type="text" placeholder="Nama Lengkap" required />
                </div>
                <div class="input-box">
                  <input v-model="dataRegister.email" type="text" placeholder="Email" required />
                </div>
                <p class="text-danger mt-2" v-if="emailValid">Email Sudah Digunakan</p>
                <div class="input-box">
                  <input v-model="dataRegister.password" type="password" placeholder="Password" required />
                </div>
                <div class="input-box">
                  <input
                    type="password"
                    placeholder="Konfimasi Password"
                    required
                    v-model="password2"
                  />
                </div>
                <p class="text-danger mt-2" v-if="passwordValid">Password tidak sama</p>
                <button type="submit" class="btn btn-primary w-100 mt-4">
                  Daftar
                </button>
                <div class="text sign-up-text">
                  Sudah memiliki akun ? <label for="flip">Masuk</label>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
      </div>
    </div>
  </body>
</template>

<script>
import userService from "@/services/ektpService"
export default {
  name: "AuthComponent",
  data(){
    return{
      dataLogin: {
        email : null,
        password: null
      },
      dataRegister: {
        nama: null,
        email: null,
        password: null
      },
      password2: null,
      loginValid: false,
      registerSuccess: false,
      emailValid: false,
      passwordValid: false,
      success: false

    }
  },
  methods: {
    login(){
      let data = this.dataLogin;
      userService.login(data).then(response => {
        console.log(response);
        this.$router.push("/home");
      }).catch(e => {
        console.log(e);
        this.loginValid = true;
      })
    },


    register(){
      let data = this.dataRegister;
      let password1 = data.password;
      let password2 = this.password2;

      this.emailValid = false;
      this.passwordValid = false;

      if(password1 == password2){
        userService.addUser(data).then(response => {
          console.log(response);
          this.success = true;
          this.dataRegister = {};
          this.password2 = "";
        }).catch(e => {
          console.log(e);
          this.emailValid = true;
        })
      } else {
        this.passwordValid = true;
      }
    }
  }
};
</script>

<style scoped lang="scss">
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: "Poppins", sans-serif;
}
body {
  min-height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
  background: #eff5f5;
  padding: 30px;
}
.container {
  position: relative;
  max-width: 850px;
  width: 100%;
  background: #fff;
  padding: 40px 30px;
  box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
  perspective: 2700px;
  border-radius: 20px;
}
.container .cover {
  position: absolute;
  top: 0;
  left: 50%;
  height: 100%;
  width: 50%;
  z-index: 98;
  transition: all 1s ease;
  transform-origin: left;
  transform-style: preserve-3d;
}
.container #flip:checked ~ .cover {
  transform: rotateY(-180deg);
}
.container .cover .front,
.container .cover .back {
  position: absolute;
  top: 0;
  left: 0;
  height: 100%;
  width: 100%;
}
.cover .back {
  transform: rotateY(180deg);
  backface-visibility: hidden;
}
.container .cover::before,
.container .cover::after {
  content: "";
  position: absolute;
  height: 100%;
  width: 100%;
  background: white;
}
.container .cover::after {
  opacity: 0.3;
  transform: rotateY(180deg);
  backface-visibility: hidden;
}
.container .cover img {
  position: absolute;
  height: 100%;
  width: 100%;
  object-fit: cover;
  z-index: 10;
}
.container .forms {
  height: 100%;
  width: 100%;
  background: #fff;
}
.container .form-content {
  display: flex;
  align-items: center;
  justify-content: space-between;
}
.form-content .login-form,
.form-content .signup-form {
  width: calc(100% / 2 - 25px);
}
.forms .form-content .title {
  position: relative;
  font-size: 24px;
  font-weight: 500;
  color: #333;
}
.forms .form-content .title:before {
  content: "";
  position: absolute;
  left: 0;
  bottom: 0;
  height: 3px;
  width: 25px;
  background: #82c3ec;
}
.forms .signup-form .title:before {
  width: 20px;
}
.forms .form-content .input-boxes {
  margin-top: 30px;
}
.forms .form-content .input-box {
  display: flex;
  align-items: center;
  height: 50px;
  width: 100%;
  margin: 10px 0;
  position: relative;
}
.form-content .input-box input {
  height: 100%;
  width: 100%;
  outline: none;
  border: none;
  padding: 0 30px;
  font-size: 16px;
  font-weight: 500;
  border-bottom: 2px solid rgba(0, 0, 0, 0.2);
  transition: all 0.3s ease;
}
.form-content .input-box input:focus,
.form-content .input-box input:valid {
  border-color: #82c3ec;
}
.form-content .input-box i {
  position: absolute;
  color: #82c3ec;
  font-size: 17px;
}
.forms .form-content .button {
  color: #fff;
  margin-top: 40px;
}
.forms .form-content .button input {
  color: #fff;
  background: #82c3ec;
  border-radius: 6px;
  padding: 0;
  cursor: pointer;
  transition: all 0.4s ease;
}
.forms .form-content .button input:hover {
  background: #009eff;
}
.forms .form-content label {
  color: #009eff;
  cursor: pointer;
}
.forms .form-content label:hover {
  text-decoration: underline;
}
.forms .form-content .login-text,
.forms .form-content .sign-up-text {
  text-align: center;
  margin-top: 25px;
}
.container #flip {
  display: none;
}
@media (max-width: 730px) {
  .container .cover {
    display: none;
  }
  .form-content .login-form,
  .form-content .signup-form {
    width: 100%;
  }
  .form-content .signup-form {
    display: none;
  }
  .container #flip:checked ~ .forms .signup-form {
    display: block;
  }
  .container #flip:checked ~ .forms .login-form {
    display: none;
  }
}
</style>