-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 23, 2021 lúc 01:44 PM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qlks_db`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bang_kiem_tra_dinh_ki`
--

CREATE TABLE `bang_kiem_tra_dinh_ki` (
  `MA_KTDK` int(10) NOT NULL,
  `TEN_PHONG` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NGAY_KT` date DEFAULT NULL,
  `GIO_BD` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GIO_KT` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TRANGTHAISAUKT` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GHI_CHU` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `bang_kiem_tra_dinh_ki`
--

INSERT INTO `bang_kiem_tra_dinh_ki` (`MA_KTDK`, `TEN_PHONG`, `NGAY_KT`, `GIO_BD`, `GIO_KT`, `TRANGTHAISAUKT`, `GHI_CHU`) VALUES
(1, '102', '2021-04-01', '2', '3', 'Bình thường', 'qweqweqwe');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cham_cong`
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
-- Cấu trúc bảng cho bảng `datcoc`
--

CREATE TABLE `datcoc` (
  `MA_DATCOC` int(10) NOT NULL,
  `SOTIENKHACHDATCOC` int(10) DEFAULT NULL,
  `SOTIENCANDATCOC` int(10) DEFAULT NULL,
  `NGAYDATCOC` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `datcoc`
--

INSERT INTO `datcoc` (`MA_DATCOC`, `SOTIENKHACHDATCOC`, `SOTIENCANDATCOC`, `NGAYDATCOC`) VALUES
(1, 0, 0, '0000-00-00'),
(2, 100000, 250000, '2021-03-31');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `dv`
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
-- Đang đổ dữ liệu cho bảng `dv`
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
-- Cấu trúc bảng cho bảng `hoadon_thanhtoanphong`
--

CREATE TABLE `hoadon_thanhtoanphong` (
  `MA_HD_TTP` int(10) NOT NULL,
  `MA_PT` int(10) DEFAULT NULL,
  `MAPHIEUDV` int(10) DEFAULT NULL,
  `MAKH` int(10) DEFAULT NULL,
  `TENKH` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NGAYTHANHTOAN` date DEFAULT NULL,
  `TIENPHONG` int(11) DEFAULT NULL,
  `TONGTIENDV` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TONGTIEN` int(11) DEFAULT NULL,
  `TINHTRANG` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hoadon_thanhtoanphong`
--

INSERT INTO `hoadon_thanhtoanphong` (`MA_HD_TTP`, `MA_PT`, `MAPHIEUDV`, `MAKH`, `TENKH`, `NGAYTHANHTOAN`, `TIENPHONG`, `TONGTIENDV`, `TONGTIEN`, `TINHTRANG`) VALUES
(1, 1, 1, 1, 'qwe', '2021-04-02', 500000, '', 1000000, 'Đã Thanh Toán'),
(2, 2, 2, 2, 'qwe', '2021-03-31', 3000000, '', 6000000, 'Đã Thanh Toán'),
(3, 3, 3, 3, 'qwe', '2021-04-08', 3000000, '', 6000000, 'Đã Thanh Toán');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoa_don`
--

CREATE TABLE `hoa_don` (
  `MA_HD` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MA_TB` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TENTB` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LOAI_HD` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SOPHONG` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SOLUONG` int(5) DEFAULT NULL,
  `LIDONANGCAP` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NGAYBD` date DEFAULT NULL,
  `NGAYKT` date DEFAULT NULL,
  `TINHTRANG` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CHIPHI` int(10) DEFAULT NULL,
  `TONGTIEN` int(10) DEFAULT NULL,
  `DUYETTHANHTOAN` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hoa_don`
--

INSERT INTO `hoa_don` (`MA_HD`, `MA_TB`, `TENTB`, `LOAI_HD`, `SOPHONG`, `SOLUONG`, `LIDONANGCAP`, `NGAYBD`, `NGAYKT`, `TINHTRANG`, `CHIPHI`, `TONGTIEN`, `DUYETTHANHTOAN`) VALUES
('1', NULL, NULL, 'Sửa Chữa Thiết Bị', '102', NULL, 'qweqwe', '2021-04-08', '2021-04-09', 'wqeqwe', 123123, 231232, 'Chưa Thanh Toán'),
('2', '1', 'Máy lạnh', 'Sửa Chữa Thiết Bị', NULL, 2, NULL, '2021-04-01', '2021-04-14', 'qwe', 12312412, 12124123, 'Chưa Thanh Toán');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `MAKH` int(10) NOT NULL,
  `TENKH` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `GIOITINH` varchar(3) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DIACHI` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NGAYSINH` date DEFAULT NULL,
  `SDT` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CMND` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `QUOCTICH` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`MAKH`, `TENKH`, `GIOITINH`, `DIACHI`, `NGAYSINH`, `SDT`, `CMND`, `QUOCTICH`) VALUES
(1, 'qwe', NULL, NULL, NULL, '12', '23', NULL),
(2, 'qwe', NULL, NULL, NULL, '23', '123', NULL),
(3, 'qwe', NULL, NULL, NULL, '12123', '2131', NULL),
(4, 'qweqwe', NULL, NULL, NULL, '123123', '123123', NULL),
(5, 'qweqwe', NULL, NULL, NULL, '123123', '123123', NULL),
(6, 'qweqwe', NULL, NULL, NULL, '21312', '12312', NULL),
(7, 'qwqwe', NULL, NULL, NULL, '3213', '2131', NULL),
(8, 'qwewqe', NULL, NULL, NULL, '31232', '2131', NULL),
(9, 'qwe', NULL, NULL, NULL, '3213', '1231', NULL),
(10, 'qwe', NULL, NULL, NULL, '21323', '213123', NULL),
(11, 'qweq', NULL, NULL, NULL, '23', '12312', NULL),
(12, 'qweq', NULL, NULL, NULL, '4324', '213123', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loai_phong`
--

CREATE TABLE `loai_phong` (
  `MA_LOAIPHONG` int(10) NOT NULL,
  `TEN_lOAIPHONG` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `SOLUONGNGUOIO` int(11) DEFAULT NULL,
  `GIATIEN` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `loai_phong`
--

INSERT INTO `loai_phong` (`MA_LOAIPHONG`, `TEN_lOAIPHONG`, `SOLUONGNGUOIO`, `GIATIEN`) VALUES
(1, 'Standard', 2, 500000),
(2, 'Deluxe', 4, 3000000),
(3, 'Superior', 2, 700000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MANV` int(10) NOT NULL,
  `TENNV` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CHUCVU` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CA_LAM` int(10) DEFAULT NULL,
  `TRANGTHAI` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NGAYLAMVIEC` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SDT` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GIOITINH` varchar(3) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NGAYSINH` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`MANV`, `TENNV`, `CHUCVU`, `CA_LAM`, `TRANGTHAI`, `NGAYLAMVIEC`, `SDT`, `GIOITINH`, `NGAYSINH`) VALUES
(1, 'qwe', 'Quản Lý', 1, 'Offline', '2021-04-01', '23123123', 'Nữ', '2021-04-22');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieuthuephong`
--

CREATE TABLE `phieuthuephong` (
  `MA_PT` int(10) NOT NULL,
  `MA_PHONG` int(10) DEFAULT NULL,
  `MAKH` int(10) DEFAULT NULL,
  `MA_DATCOC` int(10) DEFAULT NULL,
  `NGAYDAT` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MA_DATPHONG` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NGAYNHAN` date DEFAULT NULL,
  `SONGAYO` int(11) DEFAULT NULL,
  `LOAIPHONG` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SOPHONG` int(10) DEFAULT NULL,
  `SONGUOI1PHONG` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phieuthuephong`
--

INSERT INTO `phieuthuephong` (`MA_PT`, `MA_PHONG`, `MAKH`, `MA_DATCOC`, `NGAYDAT`, `MA_DATPHONG`, `NGAYNHAN`, `SONGAYO`, `LOAIPHONG`, `SOPHONG`, `SONGUOI1PHONG`) VALUES
(1, NULL, 1, NULL, '2021-03-30', '2', '2021-04-01', 2, 'Standard', 102, 1),
(2, NULL, 2, NULL, '2021-04-01', '1', '2021-04-09', 2, 'Deluxe', 102, 1),
(3, NULL, 3, NULL, '', '', '2021-04-01', 2, 'Deluxe', 103, 1),
(4, NULL, 4, NULL, '2021-04-01', '3', '2021-04-21', 2, 'Standard', 103, 1),
(5, NULL, 5, NULL, '', '', '2021-04-01', 2, 'Standard', 104, 1),
(6, NULL, 6, NULL, '2021-04-01', 'wqeq', '2021-04-20', 2, 'Deluxe', 101, 1),
(7, NULL, 7, NULL, '', '', '2021-04-01', 2, 'Superior', 106, 1),
(8, NULL, 8, NULL, '', '', '2021-04-01', 2, 'Deluxe', 101, 1),
(9, NULL, 9, NULL, '2021-04-01', '1', '2021-04-21', 2, 'Deluxe', 105, 1),
(10, NULL, 10, NULL, '', '', '2021-04-01', 2, 'Superior', 102, 2),
(11, NULL, 11, NULL, '', '', '2021-04-01', 2, 'Superior', 106, 2),
(12, NULL, 12, NULL, '', '', '2021-04-01', 2, 'Standard', 103, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieu_dv`
--

CREATE TABLE `phieu_dv` (
  `MAPHIEUDV` int(10) NOT NULL,
  `MA_DV` int(10) NOT NULL,
  `TENDV` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `TONGTIENDV` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phong`
--

CREATE TABLE `phong` (
  `MA_PHONG` int(10) NOT NULL,
  `MA_KT_DK` int(10) DEFAULT NULL,
  `MA_LOAIPHONG` int(10) DEFAULT NULL,
  `THIETBI` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TEN_PHONG` int(10) DEFAULT NULL,
  `SONGUOIO` int(11) DEFAULT NULL,
  `TINHTRANG` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phong`
--

INSERT INTO `phong` (`MA_PHONG`, `MA_KT_DK`, `MA_LOAIPHONG`, `THIETBI`, `TEN_PHONG`, `SONGUOIO`, `TINHTRANG`) VALUES
(1, 1, 2, '[Giường ngủ, Bàn đầu giường, Ti vi, Tủ lạnh ]', 101, 3, 'Đã sử dụng'),
(2, 2, 3, NULL, 102, 2, 'Trống'),
(3, 3, 1, NULL, 103, 2, 'Đã sử dụng'),
(4, 4, 1, NULL, 104, 2, 'Trống'),
(5, 5, 2, NULL, 105, 4, 'Trống'),
(6, 6, 3, NULL, 106, 2, 'Trống');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `MATK` int(10) NOT NULL,
  `USERNAME` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PSW` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CHUCVU` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thiet_bi`
--

CREATE TABLE `thiet_bi` (
  `MA_THIETBI` int(10) NOT NULL,
  `TEN_THIETBI` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NGAY_NHAP` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NGAY_XUAT` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TINHTRANG` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `VI_TRI` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `thiet_bi`
--

INSERT INTO `thiet_bi` (`MA_THIETBI`, `TEN_THIETBI`, `NGAY_NHAP`, `NGAY_XUAT`, `TINHTRANG`, `VI_TRI`) VALUES
(1, 'Máy lạnhdddd', '2021-04-01', '2021-04-03', 'Bình thường', 'qweqw');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thongke`
--

CREATE TABLE `thongke` (
  `MA_THONGKE` int(10) NOT NULL,
  `MANV` int(10) NOT NULL,
  `TEN_THONGKE` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `LOAI_THONGKE` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `NGAYLAP` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `bang_kiem_tra_dinh_ki`
--
ALTER TABLE `bang_kiem_tra_dinh_ki`
  ADD PRIMARY KEY (`MA_KTDK`);

--
-- Chỉ mục cho bảng `cham_cong`
--
ALTER TABLE `cham_cong`
  ADD PRIMARY KEY (`MA_CC`),
  ADD KEY `fk_NHANVIEN3` (`MANV`);

--
-- Chỉ mục cho bảng `datcoc`
--
ALTER TABLE `datcoc`
  ADD PRIMARY KEY (`MA_DATCOC`);

--
-- Chỉ mục cho bảng `dv`
--
ALTER TABLE `dv`
  ADD PRIMARY KEY (`MA_DV`);

--
-- Chỉ mục cho bảng `hoadon_thanhtoanphong`
--
ALTER TABLE `hoadon_thanhtoanphong`
  ADD PRIMARY KEY (`MA_HD_TTP`),
  ADD KEY `fk_PHIEUTHUEPHONG1` (`MA_PT`),
  ADD KEY `fk_KHACHHANG2` (`MAKH`),
  ADD KEY `MAPHIEUDV` (`MAPHIEUDV`);

--
-- Chỉ mục cho bảng `hoa_don`
--
ALTER TABLE `hoa_don`
  ADD PRIMARY KEY (`MA_HD`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MAKH`);

--
-- Chỉ mục cho bảng `loai_phong`
--
ALTER TABLE `loai_phong`
  ADD PRIMARY KEY (`MA_LOAIPHONG`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MANV`);

--
-- Chỉ mục cho bảng `phieuthuephong`
--
ALTER TABLE `phieuthuephong`
  ADD PRIMARY KEY (`MA_PT`),
  ADD KEY `fk_DATCOC` (`MA_DATCOC`),
  ADD KEY `fk_KHACHHANG` (`MAKH`),
  ADD KEY `fk_PHONG` (`MA_PHONG`);

--
-- Chỉ mục cho bảng `phieu_dv`
--
ALTER TABLE `phieu_dv`
  ADD PRIMARY KEY (`MAPHIEUDV`),
  ADD KEY `fk_DICHVU1` (`MA_DV`);

--
-- Chỉ mục cho bảng `phong`
--
ALTER TABLE `phong`
  ADD PRIMARY KEY (`MA_PHONG`),
  ADD KEY `fk_LOAIPHONG` (`MA_LOAIPHONG`),
  ADD KEY `fk_THIETBI` (`THIETBI`),
  ADD KEY `fk_KTDK` (`MA_KT_DK`);

--
-- Chỉ mục cho bảng `thongke`
--
ALTER TABLE `thongke`
  ADD PRIMARY KEY (`MA_THONGKE`),
  ADD KEY `fk_NHANVIEN1` (`MANV`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `cham_cong`
--
ALTER TABLE `cham_cong`
  MODIFY `MA_CC` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `loai_phong`
--
ALTER TABLE `loai_phong`
  MODIFY `MA_LOAIPHONG` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
