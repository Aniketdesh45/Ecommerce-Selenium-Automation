# 🛒 E-commerce Selenium Automation (SauceDemo)

Automated end-to-end testing for the *SauceDemo E-commerce website* using  
*Java · Selenium WebDriver · TestNG · Maven · Page Object Model (POM)*

--------------------------

## ✔ Features Covered

### 🔐 Login
- Valid login with standard user
- Invalid login (wrong password) with error message validation

### 🛍 Products & Cart
- Add single & multiple products to cart
- Validate cart badge count
- Verify product names & item count in cart
- Remove product from cart

### 💳 Checkout
- Complete checkout flow with user details
- Validate *"Thank you for your order!"* confirmation message

-----------------------------------

## 🧰 Tech Stack
| Tool | Purpose |
|------|---------|
| Java | Programming language |
| Selenium WebDriver | UI automation |
| TestNG | Test execution & assertions |
| Maven | Build & dependency manager |
| WebDriverManager | Auto driver download |
| ChromeOptions | Handling popups & notifications |
| Eclipse | IDE |

---------------

## 📂 Project Structure

src/test/java ├─ base 
              │    └─ BaseTest.java 
              ├─ pages 
              │    ├─ LoginPage.java 
              │    ├─ ProductsPage.java 
              │    ├─ CartPage.java 
              │    └─ CheckoutPage.java 
              └─ tests └─ E2ECheckoutTest.java
              pom.xml testng.xml

## 🚀 How to Run the Project

1. Clone the repo  
   ```bash git clone https://github.com/Aniketdesh45/Ecommerce-seleniumAutomation.git
2. Open project in Eclipse / IntelliJ
3. Run Maven → Update Project to download dependencies
4. Right-click testng.xml → Run As → TestNG Suite
---------------

📌 Test Flow Summary

Login → Add products → Validate cart → Checkout → Verify order success message

----------
👤 Author

Aniket Deshmukh
Automation Testing | Java | Selenium

⭐ If this project helped you, feel free to Star the repository
