# g2rain-cms

[![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](LICENSE)
[![Java Version](https://img.shields.io/badge/Java-25+-orange.svg)](https://openjdk.java.net/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.5-6DB33F?logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-2025.1.1-586069?logo=spring&logoColor=white)](https://spring.io/projects/spring-cloud)
[![Build Status](https://img.shields.io/badge/build-Maven-C71A36?logo=apachemaven&logoColor=white)](https://github.com/g2rain/g2rain-cms)

## 1. 寰芥爣涓庣姸鎬佹爣璇?
- 褰撳墠浠撳簱閲囩敤缁熶竴鐨?G2rain README 寰芥爣鏍峰紡
- 杩愯鐜瑕佹眰涓?`Java 25+`
- 褰撳墠鏋勫缓鏂瑰紡浠?`Maven` 涓哄噯
- 褰撳墠寮€婧愯鍙瘉涓?`Apache 2.0`

## 2. 椤圭洰绠€浠?
`g2rain-cms` 鏄?G2rain 骞冲彴涓殑 CMS 涓氬姟鍩熷悗绔湇鍔★紝璐熻矗鎻愪緵绔欑偣銆佺┖闂淬€佹爮鐩€侀〉闈€佹枃绔犮€佸垎绫汇€佹爣绛惧強鍏跺叧绯荤鐞嗙瓑鍐呭绠＄悊鑳藉姏銆?
## 3. 骞冲彴瀹氫綅

`g2rain-cms` 浣嶄簬 G2rain 骞冲彴涓氬姟鍩熸墿灞曞眰锛屾槸骞冲彴鍐呭绠＄悊鑳藉姏鐨勯噸瑕佸悗绔壙杞芥湇鍔°€? 
瀹冮潰鍚戝畼缃戙€佸唴瀹硅繍钀ャ€佺煡璇嗗唴瀹圭鐞嗗強鐩稿叧鍓嶇搴旂敤锛岃緭鍑虹粺涓€鐨?CMS 绠＄悊鎺ュ彛涓庡唴瀹圭粍缁囪兘鍔涖€? 
瀹冨湪涓氬姟涓婂己璋冨唴瀹圭粨鏋勫拰鍐呭鍏崇郴锛屽湪宸ョ▼涓婇伒寰钩鍙扮粺涓€鐨勫妯″潡鍚庣鏈嶅姟鏍囧噯銆?
## 4. 鏍稿績鑳藉姏

- 绔欑偣銆佺┖闂淬€佹爮鐩€侀〉闈㈢殑鍩虹绠＄悊
- 鏂囩珷銆佹枃绔犲垎绫汇€佹爣绛剧殑鍐呭缁勭粐涓庣淮鎶?- 鏂囩珷涓庢爣绛惧叧绯荤殑鎵归噺鍘婚噸缁戝畾
- 鐘舵€佹洿鏂板瀷鍐呭娌荤悊鑳藉姏
- 鍩轰簬 `codegen.properties` 鐨勭敓鎴愬紡宸ョ▼缁勭粐鑳藉姏
- 骞冲彴绾?Web 寮€鍏充笌鏁版嵁闅旂鑳藉姏鎺ュ叆

## 5. 鎶€鏈爤

- 璇█涓庤繍琛屾椂锛歚Java 25`
- 鍚庣妗嗘灦锛歚Spring Boot 4.0.5`銆乣Spring Cloud 2025.1.1`
- Web 灞傦細`Spring MVC`
- 鏈嶅姟娌荤悊锛歚Nacos Discovery`銆乣Nacos Config`
- 鎸佷箙鍖栵細`MyBatis`銆乣MySQL`
- 缂撳瓨锛歚Redis`
- 瀵硅薄杞崲锛歚MapStruct`
- 骞冲彴鎵╁睍锛歚g2rain-starter-aegis-core`銆乣g2rain-starter-data-redis`銆乣g2rain-starter-mybatis-extensions`
- 宸ョ▼鍖栵細`g2rain-generator-maven-plugin`
- 浜や粯鏂瑰紡锛歚Maven`銆乣Jib`銆乣build.sh`

## 6. 蹇€熷紑濮?
### 鐜瑕佹眰

- `JDK 25`
- `Maven 3.9+`
- 鍙敤鐨?`MySQL`
- 鍙敤鐨?`Redis`
- 鍙敤鐨?`Nacos`

### 鏈湴鏋勫缓

```bash
mvn clean install -DskipTests
```

### 鏈湴杩愯

```bash
cd g2rain-cms-startup
mvn spring-boot:run
```

鎴栵細

```bash
java -jar g2rain-cms-startup/target/g2rain-cms-startup-1.0-SNAPSHOT.jar
```

### 鏁版嵁鍒濆鍖?
```bash
mysql -u root -p < scripts/cms.sql
```

### 闀滃儚鏋勫缓

```bash
build.sh latest
```

### 浜や粯璇存槑

- 鏈嶅姟榛樿绔彛涓?`8080`
- 鏈€缁堣繍琛屾ā鍧椾负 `g2rain-cms-startup`
- 褰撳墠浠撳簱鏈彂鐜扮嫭绔?`Dockerfile`锛岄暅鍍忔瀯寤轰互 Jib 涓轰富

## 7. 椤圭洰缁撴瀯

```text
g2rain-cms/
鈹溾攢 codegen.properties
鈹溾攢 build.sh
鈹溾攢 scripts/
鈹? 鈹斺攢 cms.sql
鈹溾攢 g2rain-cms-api/
鈹? 鈹斺攢 src/main/java/com/g2rain/cms/
鈹?    鈹溾攢 api
鈹?    鈹溾攢 dto
鈹?    鈹斺攢 vo
鈹溾攢 g2rain-cms-biz/
鈹? 鈹溾攢 src/main/java/com/g2rain/cms/
鈹? 鈹? 鈹溾攢 controller
鈹? 鈹? 鈹溾攢 service
鈹? 鈹? 鈹溾攢 dao
鈹? 鈹? 鈹溾攢 converter
鈹? 鈹? 鈹斺攢 dto
鈹? 鈹斺攢 src/main/resources/mybatis/mapper/
鈹斺攢 g2rain-cms-startup/
   鈹溾攢 src/main/java/com/g2rain/
   鈹? 鈹溾攢 Application.java
   鈹? 鈹斺攢 config
   鈹斺攢 src/main/resources/
      鈹溾攢 application.yml
      鈹溾攢 application-dev.yml
      鈹斺攢 application-nacos.yml
```

### 鏍稿績涓氬姟娴佺▼浠嬬粛

#### 1. CMS 鍩虹瀹炰綋缁存姢娴佺▼

- `g2rain-cms-api` 缁熶竴瀹氫箟绔欑偣銆佺┖闂淬€佹爮鐩€侀〉闈€佹枃绔犮€佸垎绫汇€佹爣绛剧浉鍏?API
- `g2rain-cms-biz` 涓殑鎺у埗鍣ㄥ疄鐜拌繖浜涘绾﹀苟杩斿洖缁熶竴 `Result`
- ServiceImpl 灏?DTO 杞崲涓?PO锛屽苟璐熻矗鏂板銆佹洿鏂般€佸垹闄ら€昏緫
- 鏂板鏃剁粺涓€浣跨敤 `IdGenerator` 鐢熸垚涓婚敭锛屽苟鍐欏叆 `createTime`銆乣updateTime`
- 鏇存柊鏃舵寜涓婚敭鍒锋柊鏁版嵁涓?`updateTime`

#### 2. 鍐呭缁勭粐娴佺▼

- `WebSite` 鎵胯浇绔欑偣灞傜骇鍐呭鍏ュ彛
- `Space` 鐢ㄤ簬鍖哄垎鍐呭绌洪棿鎴栧唴瀹瑰鍣?- `Channel` 鎵胯浇鏍忕洰缁勭粐
- `Page` 鎵胯浇椤甸潰鍐呭
- `Article` 鎵胯浇鏂囩珷涓讳綋鍐呭
- `ArticleCategory` 鍜?`Tag` 鍏卞悓鎵挎媴鍐呭鍒嗙被涓庢绱綋绯?
#### 3. 鐘舵€佹不鐞嗘祦绋?
- `WebSite`銆乣Space`銆乣Channel`銆乣Page`銆乣ArticleCategory` 绛夊疄浣撻兘鎻愪緵鐙珛鐘舵€佹洿鏂版祦绋?- ServiceImpl 浼氬厛鏍￠獙 `id` 涓?`status`
- 鍐嶆瀯閫犱粎鍖呭惈鐘舵€佸拰鏇存柊鏃堕棿鐨勮交閲忓璞″仛灞€閮ㄦ洿鏂?- 杩欑鍋氭硶閫傚悎鍐呭鍙戝竷銆佷笅绾裤€佸惎鍋滅瓑绠＄悊鍔ㄤ綔

#### 4. 鏂囩珷鏍囩鍏崇郴娴佺▼

- `ArticleTagRelationServiceImpl.batchAddTags` 鎺ユ敹 `articleId + tagIds`
- 浼氬厛瀵逛紶鍏ユ爣绛?ID 鍋氶潪绌鸿繃婊や笌鍘婚噸
- 鍐嶆煡璇㈠綋鍓嶆枃绔犲凡鏈夌殑鏍囩鍏崇郴
- 鍙负缂哄け鐨勫叧绯荤敓鎴愭柊璁板綍
- 鏁翠釜鎵归噺缁戝畾娴佺▼鍦ㄤ簨鍔′腑鎵ц锛岄伩鍏嶉噸澶嶅叧绯诲拰閮ㄥ垎鍐欏叆闂

#### 5. 鍚姩涓庡钩鍙版帴鍏ユ祦绋?
- `g2rain-cms-startup` 璐熻矗缁熶竴瑁呴厤 Spring Boot 杩愯鐜
- 搴旂敤娉ㄥ唽鍚嶄负 `g2rain-cms`
- 閫氳繃 `application.yml` 鎺ュ叆 Nacos 閰嶇疆涓績涓庢敞鍐屼腑蹇?- 閫氳繃 `g2rain.web.*` 鎺у埗鐧诲綍瀹堝崼銆佽韩浠藉弬鏁版敞鍏ャ€佺粺涓€寮傚父 JSON 绛夊钩鍙?Web 琛屼负
- 閫氳繃 `g2rain.data.isolation.enabled=true` 寮€鍚钩鍙扮骇鏁版嵁闅旂鑳藉姏
- 閫氳繃 `/v3/api-docs` 鍜?`/swagger-ui.html` 鏆撮湶 OpenAPI 鏂囨。

#### 6. 宸ョ▼鍖栫敓鎴愭祦绋?
- 鏍瑰伐绋嬮€氳繃 `codegen.properties` 鎻忚堪 CMS 棰嗗煙琛ㄧ粨鏋?- `g2rain-generator-maven-plugin` 璐熻矗鐢熸垚澶氭ā鍧椾唬鐮侀鏋?- 褰撳墠浠撳簱淇濈暀浜嗘槑鏄剧殑鐢熸垚寮?CRUD 鐗瑰緛
- 杩欐剰鍛崇潃鍚庣画鏂板 CMS 瀹炰綋鏃讹紝鍙互缁х画娌跨敤缁熶竴鐢熸垚涓庤惤鐩樻柟寮?
## 8. 甯哥敤鍛戒护

```bash
mvn clean install
mvn -pl g2rain-cms-startup -am spring-boot:run
mvn -pl g2rain-cms-startup -am compile jib:dockerBuild
build.sh latest
```

## 9. 璐ㄩ噺涓庢祴璇?
- 褰撳墠浠撳簱鏈彂鐜拌嚜鍔ㄥ寲娴嬭瘯鏂囦欢
- 鍚庣画寤鸿浼樺厛琛ュ厖锛?  - 鏂囩珷鏍囩鎵归噺缁戝畾鍘婚噸娴嬭瘯
  - 鏍忕洰 / 椤甸潰 / 绔欑偣鐘舵€佹洿鏂版祴璇?  - 鏁版嵁闅旂寮€鍏崇浉鍏虫祴璇?  - 鍏稿瀷鏌ヨ鍒嗛〉娴嬭瘯

## 10. 鐩稿叧浠撳簱

- `g2rain-cms-app`
- `g2rain-main-shell`
- `g2rain-basis`

## 11. 浣跨敤寤鸿

- 閫傚悎浣滀负骞冲彴 CMS 涓氬姟鍩熸湇鍔＄嫭绔嬮儴缃?- 閫傚悎涓虹珯鐐瑰唴瀹广€佹枃绔犲唴瀹瑰拰鍐呭杩愯惀鐩稿叧鍓嶇搴旂敤鎻愪緵缁熶竴鍚庣鑳藉姏
- 鐖?POM 涓粛淇濈暀 archetype 妯℃澘鎻忚堪锛屾寮忓澶栨枃妗ｈ浠?README 涓庡钩鍙版€昏涓哄噯
- 鑻ュ悗缁户缁敓鎴愭柊瀹炰綋锛屽缓璁悓姝ョ淮鎶?`codegen.properties`銆丼QL 鑴氭湰涓?README

## 12. 璐＄尞鎸囧崡

娆㈣繋閫氳繃鏂囨。鏀硅繘銆両ssue 鍙嶉銆佹祴璇曡ˉ鍏呫€佷唬鐮佷紭鍖栥€佸姛鑳藉寮虹瓑褰㈠紡鍙備笌璐＄尞銆?
寤鸿娴佺▼锛?1. Fork 鏈粨搴?2. 鍒涘缓鐗规€у垎鏀?3. 鎻愪氦淇敼
4. 鎺ㄩ€佸垎鏀?5. 鎻愪氦 Pull Request

鎻愪氦鍓嶈灏介噺纭繚锛?- 閬靛惊鐜版湁鎶€鏈爤涓庝唬鐮佽鑼?- 鏇存柊鐩稿叧鏂囨。
- 濡傛秹鍙婂叧閿祦绋嬶紝琛ュ厖蹇呰娴嬭瘯

## 13. 璁稿彲璇?
鏈」鐩熀浜?[Apache 2.0璁稿彲璇乚(LICENSE) 寮€婧愩€?
## 14. 鑱旂郴鎴戜滑

- **绔欑偣**: https://www.g2rain.com/
- **Issues**: [GitHub Issues](https://github.com/g2rain/g2rain/issues)
- **璁ㄨ**: [GitHub Discussions](https://github.com/g2rain/g2rain/discussions)
- **閭**: g2rain_developer@163.com

## 15. 鑷磋阿

鎰熻阿鎵€鏈変负杩欎釜椤圭洰鍋氬嚭璐＄尞鐨勫紑鍙戣€呬滑銆? 
濡傛灉杩欎釜椤圭洰瀵规偍鏈夊府鍔╋紝娆㈣繋 Star 鏀寔銆?