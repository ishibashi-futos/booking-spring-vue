# 会議予約システム（サンプルアプリ）のSpringBoot & Vueによる実装です

![](https://github.com/ishibashi-futos/booking-spring-vue/workflows/build%20api/badge.svg)
![](https://github.com/ishibashi-futos/booking-spring-vue/workflows/build%20ui/badge.svg)

## API 

* Java: 11
* SpringBoot: 2.2.6.RELEASE

## Run or Build and UnitTest

* Run: `./gradlew bootRun`
* Build: `./gradlew build`
* UnitTest: `./gradlew test`

## UI

* Vue: 2.6.11
* typescript, jest, vuex, router

* Run: `npm run serve` open http://localhost:3000
  * ポートを変更する場合、ui/vue.config.jsの**devServer.port**を変更すること
* Build: `npm run build`
* UnitTest: `npm run test:unit`
  * with Coverage: `npm run test:unit -- --covergae` report output to `coverage/`
