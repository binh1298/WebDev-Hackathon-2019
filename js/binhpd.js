function changeDropDownValue(selection, needSource)
{
    var dropDownList = selection.parentNode;
    var dropDownBtn = dropDownList.parentNode.getElementsByTagName("button")[0];
    var sourceField = dropDownBtn.parentNode.parentNode.getElementsByClassName("binhpd-resource-code")[0];
    dropDownBtn.innerHTML = selection.innerHTML;
    if(!needSource)
    {
        sourceField.style.visibility = "hidden"; 
    } else
    {
        sourceField.style.visibility = ""; 
    }
    console.log(dropDownBtn);
}