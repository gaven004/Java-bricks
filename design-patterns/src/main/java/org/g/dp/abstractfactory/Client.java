package org.g.dp.abstractfactory;

public class Client {
    private AbstractFactory factory;

    public Client(AbstractFactory factory) {
        this.factory = factory;
    }

    public void someOperation() {
        AbstractProductA productA = factory.createProductA();
        productA.operationA1();

        AbstractProductB productB = factory.createProductB();
        productB.operationB1();
    }
}
