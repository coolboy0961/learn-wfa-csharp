Feature: HelloWorldのメッセージボックスを表示する
  ユーザーがClickMeボタンをクリックするとメッセージボックスが表示される

  Scenario: ClickMeボタンをクリックする
    Given Schemeマイグレーション
    Given DataBaseを準備する
    When ユーザーがClickMeボタンをクリックする
    Then "Hello World!"のメッセージボックスが表示される
    Then データベースに"user"テーブルのデータが正しく存在する