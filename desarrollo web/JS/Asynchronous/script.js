const result = document.getElementById('result');

let approval = "not approved!";

function getApproval () {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve("Approved");
        }, 2000);
    });
};

// this does work but we're going to use otther way to call this
//asynchronous functions.. and that is using : async - await
/*
getApproval().then(
    (resolveApproval) => {
        result.textContent = resolveApproval;
    }
);
result.textContent = approval;
*/

//async - await

async function serApprovalText () {
    const approvaPromsie = getApproval();
    result.textContent = await approvaPromsie;
};

setApprovalText();