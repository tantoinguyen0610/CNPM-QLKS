-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 06, 2021 at 05:28 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qlks_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `bang_kiem_tra_dinh_ki`
--

CREATE TABLE `bang_kiem_tra_dinh_ki` (
  `MA_KT_DK` int(10) NOT NULL,
  `NGAY_KT` date DEFAULT NULL,
  `GIO_BD` time DEFAULT NULL,
  `GIO_KT` time DEFAULT NULL,
  `TRANGTHAISAUKT` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GHI_CHU` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `bang_kiem_tra_dinh_ki`
--

INSERT INTO `bang_kiem_tra_dinh_ki` (`MA_KT_DK`, `NGAY_KT`, `GIO_BD`, `GIO_KT`, `TRANGTHAISAUKT`, `GHI_CHU`) VALUES
(1, NULL, NULL, NULL, 'Cần sửa chữa', 'Sửa chữa tủ, sơn lại'),
(2, NULL, NULL, NULL, 'Bình thường', NULL),
(3, NULL, NULL, NULL, 'Cần nâng cấp, bảo tr', 'Phòng hư hỏng nặng, tủ tróc sơn, gạch sàn nứt');

-- --------------------------------------------------------

--
-- Table structure for table `cham_cong`
--

CREATE TABLE `cham_cong` (
  `MA_CC` int(10) NOT NULL,
  `MANV` int(10) NOT NULL,
  `NGAYCHAM` date DEFAULT NULL,
  `GIOCHAM` int(11) DEFAULT NULL,
  `SOGIOLAM` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `datcoc`
--

CREATE TABLE `datcoc` (
  `MA_DATCOC` int(10) NOT NULL,
  `SOTIENKHACHDATCOC` int(10) DEFAULT NULL,
  `SOTIENCANDATCOC` int(10) DEFAULT NULL,
  `NGAYDATCOC` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `datcoc`
--

INSERT INTO `datcoc` (`MA_DATCOC`, `SOTIENKHACHDATCOC`, `SOTIENCANDATCOC`, `NGAYDATCOC`) VALUES
(1, 0, 0, '0000-00-00'),
(2, 100000, 250000, '2021-03-31');

-- --------------------------------------------------------

--
-- Table structure for table `dv`
--

CREATE TABLE `dv` (
  `MA_DV` int(10) NOT NULL,
  `TENDV` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `LOAIDV` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SOLUONG` int(11) DEFAULT NULL,
  `KHUNGGIO` time DEFAULT NULL,
  `SONGUOITHAMGIA` int(11) DEFAULT NULL,
  `GIA` int(11) DEFAULT NULL,
  `TINHTRANG` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `dv`
--

INSERT INTO `dv` (`MA_DV`, `TENDV`, `LOAIDV`, `SOLUONG`, `KHUNGGIO`, `SONGUOITHAMGIA`, `GIA`, `TINHTRANG`) VALUES
(1, 'pepsi', 'ăn uống', 1, NULL, NULL, 10000, 'còn hàng'),
(2, 'c2 ', 'ăn uống', 1, NULL, NULL, 10000, 'còn hàng'),
(3, 'sting', 'ăn uống ', 1, NULL, NULL, 20000, 'vẫn còn'),
(4, 'Sân Bóng ', 'Giải Trí', NULL, '07:00:00', NULL, 120000, 'vẫn còn'),
(5, 'nước suối', 'ăn uống', 1, NULL, NULL, 20000, 'Còn Hàng'),
(6, 'Xem Phim', 'Giải Trí', NULL, '08:00:00', NULL, 150000, 'Đang Hoạt Động'),
(7, 'Massage', 'Thư Giản', NULL, '07:00:00', NULL, 100000, 'Đang Hoạt Động'),
(8, 'Vé Máy Bay', 'Phục Vụ', 1, NULL, NULL, 100000, 'Còn Hoạt Động');

-- --------------------------------------------------------

--
-- Table structure for table `hoadon_thanhtoanphong`
--

CREATE TABLE `hoadon_thanhtoanphong` (
  `MA_HD_TTP` int(10) NOT NULL,
  `MA_PT` int(10) NOT NULL,
  `MAPHIEUDV` int(10) DEFAULT NULL,
  `MAKH` int(10) NOT NULL,
  `TENKH` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `NGAYTHANHTOAN` date DEFAULT NULL,
  `TIENPHONG` int(11) DEFAULT NULL,
  `TONGTIENDV` int(11) DEFAULT NULL,
  `PHUTHU` int(11) DEFAULT NULL,
  `TONGTIEN` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `hoa_don`
--

CREATE TABLE `hoa_don` (
  `MA_HD` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MA_HD_TTP` int(10) NOT NULL,
  `TEN_HD` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LOAI_HD` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `MAKH` int(10) NOT NULL,
  `TENKH` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `GIOITINH` varchar(3) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DIACHI` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NGAYSINH` date DEFAULT NULL,
  `SDT` int(11) DEFAULT NULL,
  `CMND` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `QUOCTICH` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NGAYCHECK_IN` date DEFAULT NULL,
  `SONGAYO` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`MAKH`, `TENKH`, `GIOITINH`, `DIACHI`, `NGAYSINH`, `SDT`, `CMND`, `QUOCTICH`, `NGAYCHECK_IN`, `SONGAYO`) VALUES
(1, 'Phú Lâm Hung', NULL, NULL, NULL, 209523, '123', NULL, NULL, NULL),
(2, 'qwe', NULL, NULL, NULL, 123, 'qwe', NULL, NULL, NULL),
(3, 'qwe', NULL, NULL, NULL, 123123, '23123123', NULL, NULL, NULL),
(4, 'tấn tới', 'nam', 'HCM', '2000-10-06', 0, '000000', 'VN', NULL, NULL),
(5, 'PHU', 'NU', 'HCM', '2000-11-01', 0, '2131212', 'VN', '2020-04-15', 3);

-- --------------------------------------------------------

--
-- Table structure for table `loai_phong`
--

CREATE TABLE `loai_phong` (
  `MA_LOAIPHONG` int(10) NOT NULL,
  `TEN_lOAIPHONG` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `SOLUONGNGUOIO` int(11) DEFAULT NULL,
  `GIATIEN` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `loai_phong`
--

INSERT INTO `loai_phong` (`MA_LOAIPHONG`, `TEN_lOAIPHONG`, `SOLUONGNGUOIO`, `GIATIEN`) VALUES
(1, 'Standard', 2, 500000),
(2, 'Deluxe', 4, 3000000),
(3, 'Superior', 2, 700000);

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MANV` int(10) NOT NULL,
  `TENNV` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CHUCVU` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GIOITINH` varchar(3) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DIACHI` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NGAYSINH` date DEFAULT NULL,
  `SDT` int(11) DEFAULT NULL,
  `EMAIL` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`MANV`, `TENNV`, `CHUCVU`, `GIOITINH`, `DIACHI`, `NGAYSINH`, `SDT`, `EMAIL`) VALUES
(1, 'asdasd', 'Quản Lý', 'Nam', NULL, NULL, NULL, NULL),
(2, 'erterte', 'Lễ Tân', 'Nam', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `phieuthuephong`
--

CREATE TABLE `phieuthuephong` (
  `MA_PT` int(10) NOT NULL,
  `MA_PHONG` int(10) DEFAULT NULL,
  `MAKH` int(10) DEFAULT NULL,
  `MA_DATCOC` int(10) DEFAULT NULL,
  `NGAYDAT` date DEFAULT NULL,
  `MA_DATPHONG` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NGAYNHAN` date DEFAULT NULL,
  `SONGAYO` int(11) DEFAULT NULL,
  `LOAIPHONG` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SOPHONG` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SONGUOI1PHONG` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `phieuthuephong`
--

INSERT INTO `phieuthuephong` (`MA_PT`, `MA_PHONG`, `MAKH`, `MA_DATCOC`, `NGAYDAT`, `MA_DATPHONG`, `NGAYNHAN`, `SONGAYO`, `LOAIPHONG`, `SOPHONG`, `SONGUOI1PHONG`) VALUES
(1, NULL, 1, NULL, '2021-04-01', '', '2021-04-01', 2, 'Standard', '101', 1),
(2, NULL, 2, NULL, '2021-04-01', '', '2021-04-23', 2, 'Standard', '101', 1),
(3, NULL, 3, NULL, '2021-04-01', '', '2021-04-15', 2, 'Standard', '102', 1);

-- --------------------------------------------------------

--
-- Table structure for table `phieu_dv`
--

CREATE TABLE `phieu_dv` (
  `MAPHIEUDV` int(10) NOT NULL,
  `MA_DV` int(10) NOT NULL,
  `TENDV` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `TONGTIENDV` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `phong`
--

CREATE TABLE `phong` (
  `MA_PHONG` int(10) NOT NULL,
  `MA_KT_DK` int(10) DEFAULT NULL,
  `MA_LOAIPHONG` int(10) DEFAULT NULL,
  `MA_THIETBI` int(10) DEFAULT NULL,
  `TEN_PHONG` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `SONGUOIO` int(11) DEFAULT NULL,
  `TINHTRANG` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `MATK` int(10) NOT NULL,
  `USERNAME` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PSW` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CHUCVU` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `thiet_bi`
--

CREATE TABLE `thiet_bi` (
  `MA_THIETBI` int(10) NOT NULL,
  `TEN_THIETBI` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `NGAY_NHAP` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `NGAY_XUAT` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TINHTRANG` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `VI_TRI` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `thongke`
--

CREATE TABLE `thongke` (
  `MA_THONGKE` int(10) NOT NULL,
  `MANV` int(10) NOT NULL,
  `TEN_THONGKE` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `LOAI_THONGKE` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `NGAYLAP` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bang_kiem_tra_dinh_ki`
--
ALTER TABLE `bang_kiem_tra_dinh_ki`
  ADD PRIMARY KEY (`MA_KT_DK`);

--
-- Indexes for table `cham_cong`
--
ALTER TABLE `cham_cong`
  ADD PRIMARY KEY (`MA_CC`),
  ADD KEY `fk_NHANVIEN3` (`MANV`);

--
-- Indexes for table `datcoc`
--
ALTER TABLE `datcoc`
  ADD PRIMARY KEY (`MA_DATCOC`);

--
-- Indexes for table `dv`
--
ALTER TABLE `dv`
  ADD PRIMARY KEY (`MA_DV`);

--
-- Indexes for table `hoadon_thanhtoanphong`
--
ALTER TABLE `hoadon_thanhtoanphong`
  ADD PRIMARY KEY (`MA_HD_TTP`),
  ADD KEY `fk_PHIEUTHUEPHONG1` (`MA_PT`),
  ADD KEY `fk_KHACHHANG2` (`MAKH`),
  ADD KEY `MAPHIEUDV` (`MAPHIEUDV`);

--
-- Indexes for table `hoa_don`
--
ALTER TABLE `hoa_don`
  ADD PRIMARY KEY (`MA_HD`),
  ADD KEY `fk_HOADON_THANHTOANPHONG` (`MA_HD_TTP`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MAKH`);

--
-- Indexes for table `loai_phong`
--
ALTER TABLE `loai_phong`
  ADD PRIMARY KEY (`MA_LOAIPHONG`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MANV`);

--
-- Indexes for table `phieuthuephong`
--
ALTER TABLE `phieuthuephong`
  ADD PRIMARY KEY (`MA_PT`),
  ADD KEY `fk_DATCOC` (`MA_DATCOC`),
  ADD KEY `fk_KHACHHANG` (`MAKH`),
  ADD KEY `fk_PHONG` (`MA_PHONG`);

--
-- Indexes for table `phieu_dv`
--
ALTER TABLE `phieu_dv`
  ADD PRIMARY KEY (`MAPHIEUDV`),
  ADD KEY `fk_DICHVU1` (`MA_DV`);

--
-- Indexes for table `phong`
--
ALTER TABLE `phong`
  ADD PRIMARY KEY (`MA_PHONG`),
  ADD KEY `fk_LOAIPHONG` (`MA_LOAIPHONG`),
  ADD KEY `fk_THIETBI` (`MA_THIETBI`),
  ADD KEY `fk_KTDK` (`MA_KT_DK`);

--
-- Indexes for table `thongke`
--
ALTER TABLE `thongke`
  ADD PRIMARY KEY (`MA_THONGKE`),
  ADD KEY `fk_NHANVIEN1` (`MANV`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bang_kiem_tra_dinh_ki`
--
ALTER TABLE `bang_kiem_tra_dinh_ki`
  MODIFY `MA_KT_DK` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `cham_cong`
--
ALTER TABLE `cham_cong`
  MODIFY `MA_CC` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `loai_phong`
--
ALTER TABLE `loai_phong`
  MODIFY `MA_LOAIPHONG` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
