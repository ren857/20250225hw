# HW
### 目錄結構
```
my-app
└─src/main/java
  ├─controller
  │    ├─member
  │      AddMemberErrorUI.java
  │      AddMemberSuccessUI.java
  │      AddMemberUI.java
  │      LoginErrorUI.java
  │      LoginSuccessUI.java
  │      LoginUI.java
  │  ├─porder
  │      AddPorderCart.java
  │      AddPorderCheckout.java
  │      AddPorderUI.java
  ├─dao
  │  │─MemberDao.java
  │  ├─PorderDao.java
  │  └─impl
  │      MemberDaoImpl.java
  │      PorderDaoImpl.java
  ├─model
  │    │─Member.java
  │    │─Porder .java
  ├─service
  │  │─MemberService.java
  │  │─PorderService.java
  │  └─impl
  │      MemberServiceImpl.java
  │      PorderServiceImpl.java
  └─util
     │─ChangeCalculator
     │─Clock
     │─PrintUtility
     │─DbConnection.java
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
