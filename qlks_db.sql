-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th3 25, 2021 lúc 03:12 AM
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
  `MA_KT_DK` int(10) NOT NULL,
  `NGAY_KT` date DEFAULT NULL,
  `GIO_BD` time DEFAULT NULL,
  `GIO_KT` time DEFAULT NULL,
  `TRANGTHAISAUKT` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GHI_CHU` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
  `ma_datCoc` int(10) NOT NULL,
  `SoTienKhachDatCoc` int(10) NOT NULL,
  `So TienCanDatCoc` int(10) NOT NULL,
  `NgayDatCoc` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `dv`
--

CREATE TABLE `dv` (
  `MA_DV` int(10) NOT NULL,
  `TENDV` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `NGAYDATDV` date NOT NULL,
  `SOLUONG` int(11) DEFAULT NULL,
  `GIO_BD` time DEFAULT NULL,
  `GIO_KT` time DEFAULT NULL,
  `SONGUOITHAMGIA` int(11) DEFAULT NULL,
  `GIA` int(11) DEFAULT NULL,
  `DANHGIACUAKH` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon_thanhtoanphong`
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
-- Cấu trúc bảng cho bảng `hoa_don`
--

CREATE TABLE `hoa_don` (
  `MA_HD` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MA_HD_TTP` int(10) NOT NULL,
  `TEN_HD` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LOAI_HD` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `MAKH` int(10) NOT NULL,
  `TENKH` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `GIOITINH` varchar(3) COLLATE utf8_unicode_ci NOT NULL,
  `DIACHI` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NGAYSINH` date DEFAULT NULL,
  `SDT` int(11) DEFAULT NULL,
  `CMND` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `QUOCTICH` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MANV` int(10) NOT NULL,
  `TENNV` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `CHUCVU` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GIOITINH` varchar(3) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DIACHI` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NGAYSINH` date DEFAULT NULL,
  `SDT` int(11) DEFAULT NULL,
  `EMAIL` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `QUOCTICH` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieuthuephong`
--

CREATE TABLE `phieuthuephong` (
  `MA_PT` int(10) NOT NULL,
  `MA_PHONG` int(10) DEFAULT NULL,
  `MAKH` int(10) DEFAULT NULL,
  `ma_datCoc` int(10) DEFAULT NULL,
  `NGAYDAT` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MA_DATPHONG` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NGAYNHAN` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SONGAYO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phieuthuephong`
--

INSERT INTO `phieuthuephong` (`MA_PT`, `MA_PHONG`, `MAKH`, `ma_datCoc`, `NGAYDAT`, `MA_DATPHONG`, `NGAYNHAN`, `SONGAYO`) VALUES
(1, NULL, NULL, NULL, '3/2/2021', 'qwe', '3/3/2021', 2),
(2, NULL, NULL, NULL, '3/2/2021', 'qwe', '3/3/2021', 2),
(3, NULL, NULL, NULL, '', '', '', 2),
(4, NULL, NULL, NULL, '3/4/2021', 'wqe', '3/24/2021', 2);

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
  `MA_THIETBI` int(10) DEFAULT NULL,
  `TEN_PHONG` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `SONGUOIO` int(11) DEFAULT NULL,
  `TINHTRANG` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `MATK` int(10) NOT NULL,
  `MANV` int(10) DEFAULT NULL,
  `USERNAME` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PSW` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thiet_bi`
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
  ADD PRIMARY KEY (`MA_KT_DK`);

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
  ADD PRIMARY KEY (`ma_datCoc`);

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
  ADD PRIMARY KEY (`MA_HD`),
  ADD KEY `fk_HOADON_THANHTOANPHONG` (`MA_HD_TTP`);

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
  ADD KEY `fk_DATCOC` (`ma_datCoc`),
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
  ADD KEY `fk_THIETBI` (`MA_THIETBI`),
  ADD KEY `fk_KTDK` (`MA_KT_DK`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`MATK`),
  ADD KEY `fk_NHANVIEN4` (`MANV`);

--
-- Chỉ mục cho bảng `thiet_bi`
--
ALTER TABLE `thiet_bi`
  ADD PRIMARY KEY (`MA_THIETBI`);

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
-- AUTO_INCREMENT cho bảng `bang_kiem_tra_dinh_ki`
--
ALTER TABLE `bang_kiem_tra_dinh_ki`
  MODIFY `MA_KT_DK` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `cham_cong`
--
ALTER TABLE `cham_cong`
  MODIFY `MA_CC` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `datcoc`
--
ALTER TABLE `datcoc`
  MODIFY `ma_datCoc` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `dv`
--
ALTER TABLE `dv`
  MODIFY `MA_DV` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `hoadon_thanhtoanphong`
--
ALTER TABLE `hoadon_thanhtoanphong`
  MODIFY `MA_HD_TTP` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `MAKH` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `loai_phong`
--
ALTER TABLE `loai_phong`
  MODIFY `MA_LOAIPHONG` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `MANV` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `phieuthuephong`
--
ALTER TABLE `phieuthuephong`
  MODIFY `MA_PT` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `phieu_dv`
--
ALTER TABLE `phieu_dv`
  MODIFY `MAPHIEUDV` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `phong`
--
ALTER TABLE `phong`
  MODIFY `MA_PHONG` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `MATK` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `thiet_bi`
--
ALTER TABLE `thiet_bi`
  MODIFY `MA_THIETBI` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `thongke`
--
ALTER TABLE `thongke`
  MODIFY `MA_THONGKE` int(10) NOT NULL AUTO_INCREMENT;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `cham_cong`
--
ALTER TABLE `cham_cong`
  ADD CONSTRAINT `FK_NHANVIEN4` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`);

--
-- Các ràng buộc cho bảng `hoadon_thanhtoanphong`
--
ALTER TABLE `hoadon_thanhtoanphong`
  ADD CONSTRAINT `fk_KH` FOREIGN KEY (`MAKH`) REFERENCES `khachhang` (`MAKH`),
  ADD CONSTRAINT `fk_PHIEUDV` FOREIGN KEY (`MAPHIEUDV`) REFERENCES `phieu_dv` (`MAPHIEUDV`),
  ADD CONSTRAINT `fk_PHIEUTHUE` FOREIGN KEY (`MA_PT`) REFERENCES `phieuthuephong` (`MA_PT`);

--
-- Các ràng buộc cho bảng `hoa_don`
--
ALTER TABLE `hoa_don`
  ADD CONSTRAINT `fk_hdttp` FOREIGN KEY (`MA_HD_TTP`) REFERENCES `hoadon_thanhtoanphong` (`MA_HD_TTP`);

--
-- Các ràng buộc cho bảng `phieuthuephong`
--
ALTER TABLE `phieuthuephong`
  ADD CONSTRAINT `fk_DATCOC` FOREIGN KEY (`ma_datCoc`) REFERENCES `datcoc` (`ma_datCoc`),
  ADD CONSTRAINT `fk_KHACHHANG` FOREIGN KEY (`MAKH`) REFERENCES `khachhang` (`MAKH`),
  ADD CONSTRAINT `fk_PHONG` FOREIGN KEY (`MA_PHONG`) REFERENCES `phong` (`MA_PHONG`);

--
-- Các ràng buộc cho bảng `phieu_dv`
--
ALTER TABLE `phieu_dv`
  ADD CONSTRAINT `fk_DV` FOREIGN KEY (`MA_DV`) REFERENCES `dv` (`MA_DV`);

--
-- Các ràng buộc cho bảng `phong`
--
ALTER TABLE `phong`
  ADD CONSTRAINT `fk_KTDK` FOREIGN KEY (`MA_KT_DK`) REFERENCES `bang_kiem_tra_dinh_ki` (`MA_KT_DK`),
  ADD CONSTRAINT `fk_LOAIPHONG` FOREIGN KEY (`MA_LOAIPHONG`) REFERENCES `loai_phong` (`MA_LOAIPHONG`),
  ADD CONSTRAINT `fk_THIETBI` FOREIGN KEY (`MA_THIETBI`) REFERENCES `thiet_bi` (`MA_THIETBI`);

--
-- Các ràng buộc cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `FK_NHANVIEN5` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`) ON UPDATE NO ACTION;

--
-- Các ràng buộc cho bảng `thongke`
--
ALTER TABLE `thongke`
  ADD CONSTRAINT `FK_NHANVIEN2` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
