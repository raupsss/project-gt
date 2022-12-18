-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 16, 2022 at 07:39 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.4.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_tugas_akhir_gt`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_anggota_keluarga`
--

CREATE TABLE `tb_anggota_keluarga` (
  `id` int(11) NOT NULL,
  `agama` varchar(255) DEFAULT NULL,
  `id_kk` varchar(255) DEFAULT NULL,
  `jenis_kelamin` varchar(255) DEFAULT NULL,
  `kepala_keluarga` varchar(255) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `nik` varchar(255) DEFAULT NULL,
  `pendidikan` varchar(255) DEFAULT NULL,
  `tanggal_lahir` varchar(255) DEFAULT NULL,
  `tempat_lahir` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_anggota_keluarga`
--

INSERT INTO `tb_anggota_keluarga` (`id`, `agama`, `id_kk`, `jenis_kelamin`, `kepala_keluarga`, `nama`, `nik`, `pendidikan`, `tanggal_lahir`, `tempat_lahir`) VALUES
(27, 'Maxime et dolores do', '24', 'Pria', 'Yes', 'INI NIK 51', '51', 'Eos molestiae dolor', '1975-02-25', 'Et officiis officia '),
(29, 'Enim omnis dicta mol', '24', 'Wanita', 'No', 'Voluptatem ea veniam', '3000', 'Deserunt natus ipsam', '2017-01-07', 'Ducimus ad quia fug'),
(30, 'Dolorum consectetur', '25', 'Pria', 'Yes', 'Ad dignissimos omnis', '212121', 'Mollitia laboris dic', '1983-10-21', 'Voluptatem ea quam ');

-- --------------------------------------------------------

--
-- Table structure for table `tb_kartu_keluarga`
--

CREATE TABLE `tb_kartu_keluarga` (
  `id` int(11) NOT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `desa_kelurahan` varchar(255) DEFAULT NULL,
  `kabupaten_kota` varchar(255) DEFAULT NULL,
  `kecamatan` varchar(255) DEFAULT NULL,
  `kode_pos` int(11) DEFAULT NULL,
  `nomor_kk` bigint(20) DEFAULT NULL,
  `provinsi` varchar(255) DEFAULT NULL,
  `rt` int(4) DEFAULT NULL,
  `rw` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_kartu_keluarga`
--

INSERT INTO `tb_kartu_keluarga` (`id`, `alamat`, `desa_kelurahan`, `kabupaten_kota`, `kecamatan`, `kode_pos`, `nomor_kk`, `provinsi`, `rt`, `rw`) VALUES
(25, 'sdqw', 'Fugiat aut cillum au', 'Quam laborum In exe', 'Amet duis officiis ', 21, 878777712, 'Rerum dolore corpori', 75, 66),
(26, 'Cupidatat occaecat i', 'Elit est eu do enim', 'Dolor ab porro eos ', 'Nulla a magni asperi', 70, 99, 'Non officia repellen', 66, 62);

-- --------------------------------------------------------

--
-- Table structure for table `tb_user`
--

CREATE TABLE `tb_user` (
  `id` int(4) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_anggota_keluarga`
--
ALTER TABLE `tb_anggota_keluarga`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nik` (`nik`);

--
-- Indexes for table `tb_kartu_keluarga`
--
ALTER TABLE `tb_kartu_keluarga`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nomor_kk` (`nomor_kk`);

--
-- Indexes for table `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_anggota_keluarga`
--
ALTER TABLE `tb_anggota_keluarga`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `tb_kartu_keluarga`
--
ALTER TABLE `tb_kartu_keluarga`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `tb_user`
--
ALTER TABLE `tb_user`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
