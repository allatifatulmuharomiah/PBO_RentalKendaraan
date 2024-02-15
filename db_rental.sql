-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 15 Feb 2024 pada 09.46
-- Versi server: 10.4.24-MariaDB
-- Versi PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_rental`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tblkendaraan`
--

CREATE TABLE `tblkendaraan` (
  `id_k` int(5) NOT NULL,
  `jenis` varchar(25) NOT NULL,
  `merek` varchar(25) NOT NULL,
  `tipe` varchar(25) NOT NULL,
  `tahun` varchar(7) NOT NULL,
  `nomor` varchar(15) NOT NULL,
  `harga` int(15) NOT NULL,
  `status` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tblkendaraan`
--

INSERT INTO `tblkendaraan` (`id_k`, `jenis`, `merek`, `tipe`, `tahun`, `nomor`, `harga`, `status`) VALUES
(111, 'Mobil', 'Dihatsu', 'SUV', '2017', 'A12945', 300000, 'Tersedia'),
(112, 'Mobil', 'Dihatsu', 'MPV', '2020', 'A4673', 310000, 'Tersedia'),
(121, 'Mobil', 'Toyota', 'MPV', '2019', 'B3456', 350000, 'Tersedia'),
(122, 'Mobil', 'Toyota', 'SUV', '2021', 'B4532', 360000, 'Tersedia'),
(211, 'Motor', 'Honda', 'Scooter', '2021', 'B5643', 80000, 'Tersedia'),
(212, 'Motor', 'Honda', 'Sport', '2019', 'C1234', 90000, 'Tersedia'),
(221, 'Motor', 'Yamaha', 'Scooter', '2018', 'A5678', 85000, 'Tersedia'),
(222, 'Motor', 'Yamaha', 'Sport', '2022', 'C3456', 95000, 'Tersedia');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbltransaksi`
--

CREATE TABLE `tbltransaksi` (
  `id_t` int(5) NOT NULL,
  `peminjam` varchar(25) NOT NULL,
  `no_telp` varchar(25) NOT NULL,
  `tipe` varchar(25) NOT NULL,
  `id_k` varchar(50) DEFAULT NULL,
  `hari` int(3) NOT NULL,
  `total` int(15) DEFAULT NULL,
  `status` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tbltransaksi`
--

INSERT INTO `tbltransaksi` (`id_t`, `peminjam`, `no_telp`, `tipe`, `id_k`, `hari`, `total`, `status`) VALUES
(1, 'Liaa', '45678', 'Daihatsu SUV', '111  Daihatsu SUV', 1, 300000, 'Proses'),
(2, 'Dika', '12345', 'Honda Scooter', '211  Honda Scooter', 5, 400000, 'Proses'),
(3, 'adi', '5678', 'Yamaha Sport', '222  Yamaha Sport', 2, 190000, 'Selesai'),
(4, 'Dina', '777', 'Honda Scooter', '211  Honda Scooter', 1, 80000, 'Proses');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tblkendaraan`
--
ALTER TABLE `tblkendaraan`
  ADD PRIMARY KEY (`id_k`);

--
-- Indeks untuk tabel `tbltransaksi`
--
ALTER TABLE `tbltransaksi`
  ADD PRIMARY KEY (`id_t`),
  ADD KEY `id_k` (`id_k`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
