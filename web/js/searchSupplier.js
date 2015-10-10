function autoComplete() {
    $("#supplierName").devbridgeAutocomplete({
        serviceUrl: 'SearchSupplierServlet',
        type: 'POST',
        showNoSuggestionNotice: true,
        noSuggestionNotice: 'No Exsiting Item',
    });
}

