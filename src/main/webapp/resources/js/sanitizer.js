
function sanitizer() {
    const head = document.getElementById("head").innerHTML;
    console.log(head)
    const cleanHead = DOMPurify.sanitize(head, null);
    document.getElementById("head").innerHTML = cleanHead;
    console.log(cleanHead)
    const body = document.getElementById("body").innerHTML;
    const cleanBody = DOMPurify.sanitize(body, null);
    document.getElementById("body").innerHTML = cleanBody;
}
