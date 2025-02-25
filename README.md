# HW
### 目錄結構
```
my-app
└─src/main/java
  ├─controller
  │  ├─consmer
  │      AddConsmerUI.java
  │      ConsmerLoginUI.java
  │  ├─employee
  │      AddEmployeeUI.java
  │      EmployeeLoginUI.java
  │      WorkStationUI.java
  │  ├─porder
  │      AddPordeUI.java
  │      CheckoutUI.java
  │      Excel.java
  ├─dao
  │  │─ConsmerDao.java
  │  ├─EmployeeDao.java
  │  ├─PorderDao.java
  │  ├─ProductDao.java 
  │  └─impl
  │      ConsmerDaoImpl.java
  │      EmployeeDaoImpl.java
  │      PorderDaoImpl.java
  │      ProductDaoImpl.java
  ├─model
  │    │─Consmer.java
  │    │─Employee.java
  │    │─Hw.java
  │    │─Porder .java
  │    │─Product.java
  ├─service
  │  │─ConsmerService.java
  │  │─EmployeeService.java
  │  │─PorderService.java
  │  │─ProductService.java
  │  └─impl
  │      ConsmerServiceImpl.java
  │      EmployeeServiceImpl.java
  │      PorderServiceImpl.java
  │      ProductServiceImpl.java
  └─util
     │─ChangeCalculator.java
     │─Clock.java
     │─DbConnection.java
     │─DBExcel.java 
     │─Tool.java
```
### 測試環境
- #### 資料庫環境：
請安裝 MySQL（使用[ MySQL Community Server](https://dev.mysql.com/downloads/mysql/ "游標顯示") (下載8.0版本)），並匯入提供的 SQL 腳本建立所需的資料表。

- #### JDK環境：
#### 下載並安裝[JDK 11](https://www.oracle.com/java/technologies/downloads/#java11?er=221886 "游標顯示")環境。  
在 CMD 中執行下列命令以確認安裝版本。
```plaintext
javac -version
```
```plaintext
java -version
```
### 下載連結 
[sql資料庫,jar執行檔](https://github.com/ren857/20250225hw/tree/main/%E4%BD%9C%E6%A5%AD5 "游標顯示")

### 實作說明:  
- #### 登入畫面 (ConsmerLoginUI.java)
<img src="https://github.com/user-attachments/assets/26ea2a42-693c-4f33-9f8f-c795ebd4e1e0" alt="示例圖像" width="500" height="500">

- #### 註冊畫面 (AddConsmerUI.java)
<img src="https://github.com/user-attachments/assets/b58e1fc3-ef85-4043-a3c1-900868a20c1a" alt="示例圖像" width="500" height="500">

- #### 購物畫面 (AddPordeUI.java)
<img src="https://github.com/user-attachments/assets/232dfb8e-ef4e-4229-a9b3-ea676e21035a" alt="示例圖像" width="500" height="500">

- #### 新增Add (AddPordeUI.java)
<img src="https://github.com/user-attachments/assets/83d8313b-1580-4abe-bbe0-7e1271a11684" alt="示例圖像" width="500" height="500">

- #### 調整Update (AddPordeUI.java)
<img src="https://github.com/user-attachments/assets/0fcd470a-6979-48c6-b51a-da12516088f3" alt="示例圖像" width="500" height="500">

- #### 刪除 (AddPordeUI.java)
<img src="https://github.com/user-attachments/assets/4410591b-c89d-4714-8db6-0a688a49e8a7" alt="示例圖像" width="500" height="500">

- #### 結帳畫面 (CheckoutUI.java)
<img src="https://github.com/user-attachments/assets/16561179-481e-4c57-943a-6ae3b55d77e0" alt="示例圖像" width="500" height="500"> 

- #### 總金額 (CheckoutUI.java)
<img src="https://github.com/user-attachments/assets/2a698b7c-266b-4cc0-887c-a444d4b71a21" alt="示例圖像" width="500" height="500"> 











