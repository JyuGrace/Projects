let stocks = {
    fruits: ["strawberry", "grapes", "banana", "apple"],
    liquid: ["water", "ice"],
    holders: ["cone", "cup", "stick"],
    topplings: ["chocolat", "peanuts"]
};

/*
let order = (fruit_name,call_prduction) => {
    setTimeout(() => {
        console.log(`${stocks.fruits[fruit_name]} was selected`);
        call_prduction();
    }, 2000);
};
// this structure is called: CALLBACK HELL
let production = () => {
    setTimeout(() => {
        console.log("Production has  started");
        setTimeout(() => {
            console.log("The fruit has been chopped");
            setTimeout(() => {
                console.log(`${stocks.liquid[0]} and ${stocks.liquid[1]} was added`);
                setTimeout(() => {
                    console.log("the machine has started");
                    setTimeout(() => {
                        console.log(`IceCream was placed on ${stocks.holders[0]}`);
                        setTimeout(() => {
                            console.log(`${stocks.topplings[0]} was added as toppling`);
                            setTimeout(() => {
                                console.log("serve IcreCream");
                            }, 2000);
                        }, 3000);
                    }, 2000);
                }, 1000);
            }, 1000);
        }, 2000);
    }, 0);
};

order(0, production);
*/

//this is another way to stae Promises and chain them
/*
let is_shop_open = true;

let order = (time, work) => {
    return new Promise((resolve, reject) => {
        if(is_shop_open) {
            setTimeout( () => {
                resolve(work());
            }, time);
        } else {
            reject(console.log("Our shop is closed"));
        };
    });
};

order(2000, () => {console.log(`${stocks.fruits[2]} was selected`)}) //if I place a " ; " here, the program doesnt work anymore

.then(() => {
    return order(0, () => {console.log("Production has started")});
})
.then(() => {
    return order(2000, () => {console.log("the fruit was chopped")})
})
.then(() => {
    return order(1000, () => {console.log(`${stocks.liquid[0]} and ${stocks.liquid[1]} wa selected`)});
})
.then(() => {
    return order(1000, () => {console.log("start the machine");});
})
.then(() => {
    return order(2000, ()=> {console.log(`Ice cream placed on ${stocks.holders[0]}`) });
})
.then(() => {
    return order(3000, () => {console.log(`${stocks.topplings[1]} was selected`)});
})
.then(() => {
    return order (1000, () => {console.log("ice cream was served")});
})

.catch(()=> {
    console.log("Customer left");
})

.finally(() => {
    console.log("day ended, shop is closed");
});
*/

let shop_is_open = true;

function time(miliSeconds){
    return new Promise((resolve, reject) => {
        if(shop_is_open) {
            setTimeout(resolve, miliSeconds);
        } else {
            reject (console.log("Shop is closed"));
        }
    })
};

async function kitchen() {
    try {
        await time(2000);
        console.log(`${stocks.fruits[0]} was selected`);
        
        await time(0);
        console.log("starting production");

        await time(2000);
        console.log("the fruits has been chopped");

        await time(1000);
        console.log(`${stocks.liquid[0]} and ${stocks.liquid[1]} was added`);

        await time(1000);
        console.log("start the machine");

        await time(2000);
        console.log(`ice cream was placed on ${stocks.holders[1]}`);

        await time(3000);
        console.log(`${stocks.topplings[1]} has been selected as toppling`);

        await time(2000);
        console.log("serving the ice cream");
    }
    catch (error){
        console.log("customer left", error);
    }
    finally {
        console.log("day ended, sop is closed");
    }
}

kitchen();