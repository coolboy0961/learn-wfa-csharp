package com.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.dbunit.Assertion;
import org.dbunit.DataSourceBasedDBTestCase;
import org.dbunit.DatabaseUnitException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.flywaydb.core.Flyway;
import org.h2.jdbcx.JdbcDataSource;

import com.example.pageobject.MainForm;

public class DisplayHelloWorldMessageBoxSteps extends DataSourceBasedDBTestCase {

    private MainForm mainForm;

    public DisplayHelloWorldMessageBoxSteps() {
        this.mainForm = new MainForm();
    }

    // DataSourceを提供するメソッド
    protected DataSource getDataSource() {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        dataSource.setUser("sa");
        dataSource.setPassword("");
        return dataSource;
    }

    // テストデータセットを提供するメソッド
    protected IDataSet getDataSet() throws Exception {
        try (InputStream is = new FileInputStream("src/test/resources/test-dataset.xml")) {
            return new FlatXmlDataSetBuilder().build(is);
        }
    }

    @Given("Schemeマイグレーション")
    public void scheme_migration() throws SQLException {
        // // Tableを作成する
        // // データベースへの接続を開始します
        // Connection connection = DriverManager.getConnection("jdbc:h2:mem:testdb:DB_CLOSE_DELAY=-1", "sa", "");
        // // SQL文を実行するためのStatementオブジェクトを作成します
        // Statement statement = connection.createStatement();
        // // SQLのCREATE TABLE文を実行します
        // // USERテーブルを作成します
        // statement.execute("CREATE TABLE USER(ID INT PRIMARY KEY, USERNAME VARCHAR(255), PASSWORD VARCHAR(255))");
        // // statement.execute("CREATE TABLE PRODUCT(ID INT PRIMARY KEY, NAME VARCHAR(255), PRICE INT)");

        // // リソースを解放します
        // statement.close();
        // connection.close();


        // Flywayのインスタンスを作成し、マイグレーションを実行します
        Flyway flyway = Flyway.configure().dataSource("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1", "sa", "").load();
        flyway.migrate();
    }

    @Given("DataBaseを準備する")
    public void database_prepare() throws Exception {
        // DBUnitでデータベースにデータを投入します
        DatabaseOperation.CLEAN_INSERT.execute(getConnection(), getDataSet());
    }

    @When("ユーザーがClickMeボタンをクリックする")
    public void the_user_clicks_the_click_me_button() {
        mainForm.clickClickMeButton();
    }

    @Then("データベースに{string}テーブルのデータが正しく存在する")
    public void verifyTableData(String tableName) throws Exception {
        // DBUnitを使ってデータベースのデータを検証します
        ITable actualTable = getConnection().createTable(tableName);
        ITable expectedTable = getDataSet().getTable(tableName);
        Assertion.assertEquals(expectedTable, actualTable);
    }
}
