function showResultValid(result, message){
    result.style.color = 'green';
    result.innerText = message;
}

function showResultInvalid(result, message){
    result.style.color = 'red';
    result.innerText = message;
}
async function fetchGet(url){

    console.log("fetchData1...1");

    try{
        console.log("fetchData1...2");
        const response = await fetch(url);
        console.log("here1");

        if(!response.ok){
            console.log("here2");
            throw new Error('response not ok');
        }

        const data = await response.json();
        console.log("data1 : " + data);

        return data;

    }catch (err) {
        console.log(err)
    }
}