class Account
{
    constructor(name,id,balance)
    {
        this.name=name;
        this.id=id;
        this.balance=balance;
    }

    get name()
    {
        return this.name;
    }
    set name(name)
    {
        this.name=name;
    }
    get id()
    {
        return this.id;
    }
    set id(id)
    {
        this.id=id;
    }
    get balance()
    {
        return this.balance;
    }
    set balance(balance)
    {
        this.balance=balance;
    }
}


class SavingsAccount extends Account
{
    constructor(name,id,balance,interest)
    {
        super(name,id,balance);
        this.interest=interest;
    }

    get name()
    {
        return this.name;
    }
    set name(name)
    {
        this.name=name;
    }
    get id()
    {
        return this.id;
    }
    set id(id)
    {
        this.id=id;
    }
    get balance()
    {
        return this.balance;
    }
    set balance(balance)
    {
        this.balance=balance;
    }
    get interest()
    {
        return this.interest;
    }
    set interest(interest)
    {
        this.interest=interest;
    }
}

class CurrentAccount extends Account
{
    constructor(name,id,balance,cashCredit)
    {
        super(name,id,balance);
        this.cashCredit=cashCredit;
    }

    get name()
    {
        return this.name;
    }
    set name(name)
    {
        this.name=name;
    }
    get id()
    {
        return this.id;
    }
    set id(id)
    {
        this.id=id;
    }
    get balance()
    {
        return this.balance;
    }
    set balance(balance)
    {
        this.balance=balance;
    }
    get cashCredit()
    {
        return this.cashCredit;
    }
    set cashCredit(cashCredit)
    {
        this.cashCredit=cashCredit;
    }
}

let savingsAccount,currentAccount;


function createObject()
{
    savingsAccount=new SavingsAccount("priyam",101,50000,10);
    currentAccount-new CurrentAccount("abhishek anand",102,5000000,5000);

}

export function calculatTotalBalanceInBank()
{
    return savingsAccount.balance+currentAccount.balance;
}