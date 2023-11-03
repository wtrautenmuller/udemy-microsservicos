import Sequelize from "sequelize";

const sequelize = new Sequelize("auth-db","postgres","admin","teste", {
    host: "localhost",
    dialect: "postgres",
    quoteIdentifiers: false,
    define: {
        syncOnAssossiation: true,
        timestamp: false,
        underscored: true,
        underscoredAll: true,
        freezeTableName: true,
    },
});

sequelize
    .authenticate()
    .then(() => {
        console.info("Connection has been stablished");
})
    .catch( (err) => {
        console.error("Unable to connect to the Database.");
        console.error(err.message);
});

export default sequelize;