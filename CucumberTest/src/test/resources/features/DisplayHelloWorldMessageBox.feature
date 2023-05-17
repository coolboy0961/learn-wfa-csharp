Feature: HelloWorldのメッセージボックスを表示する
  ユーザーがClickMeボタンをクリックするとメッセージボックスが表示される

  Scenario: ClickMeボタンをクリックする
    When ユーザーがClickMeボタンをクリックする
    Then "Hello World!"のメッセージボックスが表示される