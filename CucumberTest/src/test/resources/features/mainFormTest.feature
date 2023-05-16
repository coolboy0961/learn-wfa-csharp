Feature: メインフォームのテスト
  ユーザーがClickMeボタンをクリックするとメッセージボックスが表示される

  Scenario: ClickMeボタンをクリックする
    Given アプリケーションが実行中である
    When ユーザーがClickMeボタンをクリックする
    Then "Hello World!"のメッセージボックスが表示される