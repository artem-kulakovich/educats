
try {
    let orderRefs = document.getElementsByName("orderRef");
    for (let orderRef of orderRefs) {
        let number = orderRef.getAttribute("data-value");
        orderRef.addEventListener("click", function (e) {
            e.preventDefault();
            let orderDiv = document.querySelector("#orderDiv" + number).getAttribute("style");
            if (orderDiv === "display:none") {
                document.querySelector("#orderDiv" + number).setAttribute("style", "display:block");
            } else {
                document.querySelector("#orderDiv" + number).setAttribute("style", "display:none");

            }
        });
    }
} catch (e) {

}
