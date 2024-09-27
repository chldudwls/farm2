-- --------------------------------------------------------
-- 호스트:                          localhost
-- 서버 버전:                        8.4.0 - MySQL Community Server - GPL
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- 테이블 데이터 springfarmstory.board:~0 rows (대략적) 내보내기

-- 테이블 데이터 springfarmstory.board_file:~0 rows (대략적) 내보내기

-- 테이블 데이터 springfarmstory.cart:~0 rows (대략적) 내보내기
REPLACE INTO `cart` (`cart_idx`, `user_idx`) VALUES
	(6, 2);

-- 테이블 데이터 springfarmstory.cart_item:~0 rows (대략적) 내보내기
REPLACE INTO `cart_item` (`cart_item_idx`, `cart_idx`, `prod_idx`, `cart_item_quantity`) VALUES
	(6, 6, 1, 1),
	(7, 6, 1, 1),
	(8, 6, 1, 10),
	(9, 6, 1, 1),
	(10, 6, 1, 15),
	(11, 6, 1, 3),
	(12, 6, 2, 3),
	(13, 6, 2, 12),
	(14, 6, 2, 1),
	(15, 6, 2, 1),
	(16, 6, 2, 1),
	(17, 6, 2, 1),
	(18, 6, 2, 2),
	(19, 6, 2, 1),
	(20, 6, 2, 1);

-- 테이블 데이터 springfarmstory.comment:~0 rows (대략적) 내보내기

-- 테이블 데이터 springfarmstory.order:~0 rows (대략적) 내보내기

-- 테이블 데이터 springfarmstory.order_item:~0 rows (대략적) 내보내기

-- 테이블 데이터 springfarmstory.product:~2 rows (대략적) 내보내기
REPLACE INTO `product` (`prod_idx`, `prod_name`, `prod_type`, `prod_delivery`, `prod_price`, `prod_discount`, `prod_save_point`, `prod_stock`, `prod_create_at`, `prod_etc`) VALUES
	(1, '1515', '과일', 3000.00, 50000.00, 10.00, 500.00, 15, '2024-09-26 05:21:25', '1561'),
	(2, '바나나', '과일', 2000.00, 4000.00, 5.00, 400.00, 40, '2024-09-26 07:47:39', '');

-- 테이블 데이터 springfarmstory.product_file:~0 rows (대략적) 내보내기
REPLACE INTO `product_file` (`prod_file_idx`, `prod_idx`, `prod_file_type`, `prod_file_name`, `prod_file_path`) VALUES
	(1, 2, 'list', '626bb16d-f281-470e-b70c-604092685ba2.jfif', '/file/');

-- 테이블 데이터 springfarmstory.product_snapshot:~0 rows (대략적) 내보내기

-- 테이블 데이터 springfarmstory.test_prod:~0 rows (대략적) 내보내기

-- 테이블 데이터 springfarmstory.user:~2 rows (대략적) 내보내기
REPLACE INTO `user` (`user_idx`, `user_id`, `user_pwd`, `user_name`, `user_nick`, `user_email`, `user_hp`, `user_create_at`, `user_role`) VALUES
	(1, 'woo24465', '$2a$10$MZl7bVWEkWuehKRUotCTr.DtIfCjk7SY1y2QzO5DueWYYAwfqEhdK', '이상후훈', 'ㄴㅇㄹ', 'w@gmail.com', '01040437329', '2024-09-26 04:46:08', 'admin'),
	(2, 'woo', '$2a$10$6Kks3sV2ccCO5nzZ5Nfk5uS2HwIDCLXkKYM42R85I7PpCRdcN6Uva', 'woo', '우', 'we@gmail.com', '01040437329', '2024-09-26 04:48:14', 'admin');
-- id :woo // pw:1 234Asd@

-- 테이블 데이터 springfarmstory.user_address:~0 rows (대략적) 내보내기
REPLACE INTO `user_address` (`addr_idx`, `user_idx`, `addr_zone`, `addr`, `addr_detail`) VALUES
	(1, 1, '28456', '충북 청주시 흥덕구 1순환로 384 (신봉동)', '123'),
	(2, 2, '47261', '부산 부산진구 가야대로 지하 719 (부전동)', '건장');

-- 테이블 데이터 springfarmstory.user_point:~0 rows (대략적) 내보내기
REPLACE INTO `user_point` (`point_idx`, `user_idx`, `user_point`) VALUES
	(1, 1, 1000.00),
	(2, 2, 1000.00);

-- 테이블 데이터 springfarmstory.user_point_detail:~0 rows (대략적) 내보내기
REPLACE INTO `user_point_detail` (`point_detail_idx`, `point_idx`, `save_point`, `use_point`, `detail`) VALUES
	(1, 1, 1000.00, 0.00, '회원가입 축하 포인트'),
	(2, 2, 1000.00, 0.00, '회원가입 축하 포인트');

-- 테이블 데이터 springfarmstory.user_schedule:~0 rows (대략적) 내보내기

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
