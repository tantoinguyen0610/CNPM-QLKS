-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th3 26, 2021 lúc 04:44 AM
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
-- Cấu trúc bảng cho bảng `phieuthuephong`
--

CREATE TABLE `phieuthuephong` (
  `MA_PT` int(10) NOT NULL,
  `MA_PHONG` int(10) DEFAULT NULL,
  `MAKH` int(10) DEFAULT NULL,
  `ma_datCoc` int(10) DEFAULT NULL,
  `NGAYDAT` date DEFAULT NULL,
  `MA_DATPHONG` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NGAYNHAN` date DEFAULT NULL,
  `SONGAYO` int(11) DEFAULT NULL,
  `LOAIPHONG` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phieuthuephong`
--

INSERT INTO `phieuthuephong` (`MA_PT`, `MA_PHONG`, `MAKH`, `ma_datCoc`, `NGAYDAT`, `MA_DATPHONG`, `NGAYNHAN`, `SONGAYO`, `LOAIPHONG`) VALUES
(6, NULL, NULL, NULL, '2021-03-01', 'asdasd', '2021-03-18', 4, NULL),
(7, NULL, NULL, NULL, '2021-03-01', 'qwe', '2021-03-17', 4, NULL),
(8, NULL, NULL, NULL, '2021-03-01', 'qwe', '2021-03-17', 4, NULL),
(9, NULL, NULL, NULL, '2021-03-01', 'qwe', '2021-03-17', 4, NULL),
(10, NULL, NULL, NULL, '2021-03-01', 'qwe', '2021-03-17', 4, NULL),
(11, NULL, NULL, NULL, '2021-03-01', 'qwe', '2021-03-17', 4, NULL),
(12, NULL, NULL, NULL, '2021-03-01', 'qwe', '2021-03-17', 4, NULL),
(13, NULL, NULL, NULL, '2021-03-01', 'qwe', '2021-03-10', 4, NULL),
(14, NULL, NULL, NULL, '2021-03-01', 'qwe', '2021-03-10', 4, NULL),
(15, NULL, NULL, NULL, '2021-03-01', 'qwe', '2021-03-10', 4, NULL);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `phieuthuephong`
--
ALTER TABLE `phieuthuephong`
  ADD PRIMARY KEY (`MA_PT`),
  ADD KEY `fk_DATCOC` (`ma_datCoc`),
  ADD KEY `fk_KHACHHANG` (`MAKH`),
  ADD KEY `fk_PHONG` (`MA_PHONG`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `phieuthuephong`
--
ALTER TABLE `phieuthuephong`
  MODIFY `MA_PT` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `phieuthuephong`
--
ALTER TABLE `phieuthuephong`
  ADD CONSTRAINT `fk_DATCOC` FOREIGN KEY (`ma_datCoc`) REFERENCES `datcoc` (`ma_datCoc`),
  ADD CONSTRAINT `fk_KHACHHANG` FOREIGN KEY (`MAKH`) REFERENCES `khachhang` (`MAKH`),
  ADD CONSTRAINT `fk_PHONG` FOREIGN KEY (`MA_PHONG`) REFERENCES `phong` (`MA_PHONG`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
