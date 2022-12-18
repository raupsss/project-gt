<template>
  <aside
    class="
      main-sidebar
      bg-info
      elevation-4
      d-flex
      flex-column
      justify-content-between
    "
  >
    <router-link to="/home" class="brand-link elevation-5 bg-info">
      <img src="@/assets/ktp.png" class="brand-image img-circle elevation-3" />
      <span class="brand-text font-weight-bold ml-2">E-KTP APP</span>
    </router-link>

    <div class="sidebar">
      <nav class="mt-5">
        <ul
          class="nav nav-pills nav-sidebar flex-column"
          data-widget="treeview"
          role="menu"
          data-accordion="false"
        >
          <li class="nav-item">
            <router-link to="/home" class="nav-link text-white">
              <i class="fas fa-home"></i>
              <p class="ml-2">Home</p>
            </router-link>
          </li>
          <li class="nav-item mt-3">
            <router-link to="/addKK" class="nav-link text-white">
              <i class="fas fa-user-plus"></i>
              <p class="ml-2">Tambah KK</p>
            </router-link>
          </li>
        </ul>
      </nav>
    </div>

    <footer class="">
      <div class="sidebar mb-4">
        <nav class="">
          <ul
            class="nav nav-pills nav-sidebar flex-column"
            data-widget="treeview"
            role="menu"
            data-accordion="false"
          >
            <li class="nav-item">
              <router-link to="/" class="nav-link text-white">
                <i class="fas fa-sign-out-alt"></i>
                <p class="ml-2">Sign Out</p>
              </router-link>
            </li>
          </ul>
        </nav>
      </div>
      <p class="footer text-center">
        Copyright &copy; 2022 Raup. All rights reserved
      </p>
    </footer>
  </aside>
</template>

<script>
export default {
  name: "AppSideBar",
  data() {
    return {};
  },
};
</script>

<style lang="scss" scoped>
.footer {
  font-size: 12px;
}

.nav-item:hover{

  background-color: #344D67;
  // opacity: 50%;
  

}
</style>