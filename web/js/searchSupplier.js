function autoCompleteSupplier() {
    $("#supplierName").devbridgeAutocomplete({
        serviceUrl: 'SearchSupplierServlet',
        type: 'POST',
        showNoSuggestionNotice: true,
        noSuggestionNotice: 'No Exsiting Item',
    });
}

function autoCompleteSupplierItem() {
    $("#itemNameSupplier").devbridgeAutocomplete({
        serviceUrl: 'SearchItemSuppliersServlet',
        type: 'POST',
        showNoSuggestionNotice: true,
        noSuggestionNotice: 'No Exsiting Item',
    });
}

