# Anatomy of an HTTP Request (HTTP İsteğinin Anatomisi)

Bir **Client**, **Server** ile konusmak istediginde bir **HTTP Request (HTTP İsteği)** gonderir. Bu istegin yapisi uc ana bolumden olusur:

---

## 1. Request Line

İsteğin en başında yer alan ve sunucuya ne yapması gerektiğini söyleyen bölümdür. Üç ana bileşenden oluşur:

* **HTTP Method (HTTP Metodu):** Sunucunun gerçekleştirmesi istenen eylem türüdür.
    * `GET`: Veri çekmek için kullanılır.
    * `POST`: Yeni bir veri oluşturmak için kullanılır.
    * `PUT`: Mevcut veriyi güncellemek için kullanılır.
    * `DELETE`: Veriyi silmek için kullanılır.
* **Request URI / Path :** Erişilmek istenen kaynağın konumudur (Örn: `/api/product`).
* **HTTP Version :** Kullanılan protokol sürümüdür (Örn: `HTTP/1.1`, `HTTP/2`).

---

## 2. Request Headers

**Client**, sunucuya istek hakkında ek meta veriler gönderir. Bu veriler anahtar-değer çiftleri şeklindedir:

| Header Name (Başlık Adı) | Description (Açıklama) |
| :--- | :--- |
| **Host** | İsteğin gönderildiği domain adı (Sunucu adresi). |
| **User-Agent** | İsteği yapan tarayıcı, işletim sistemi veya kütüphane bilgisi. |
| **Accept** | İstemcinin kabul edebileceği veri formatı (Örn: `application/json`). |
| **Content-Type** | Gönderilen verinin hangi formatta olduğunu belirtir. |
| **Authorization** | Sunucuya erişim için gerekli olan **Credentials** veya **Token**. |
| **Content-Length** | Gönderilen **Body** kısmının byte cinsinden boyutu. |

---

## 3. Request Body / Payload

Sunucuya gönderilmek istenen asıl veriyi içerir. Genellikle `POST`, `PUT` ve `PATCH` metotlarında kullanılır. 

* **Format:** Modern web uygulamalarında genellikle **JSON** formatı tercih edilir.
* **Örnek:**
    ```json
    {
      "username": "ibrahim_engineer",
      "email": "cetin@example.com"
    }
    ```
