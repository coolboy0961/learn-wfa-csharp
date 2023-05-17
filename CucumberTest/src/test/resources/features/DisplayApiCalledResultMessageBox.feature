Feature: APIコールのResultのメッセージボックスを表示する
  ユーザーがCallApiボタンをクリックするとメッセージボックスが表示される

  Scenario: CallApiボタンをクリックする
    Given APIのモックがセットされている
    When ユーザーがCallApiボタンをクリックする
    Then "API Called Successfully!"のメッセージボックスが表示される