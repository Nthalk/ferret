$.fn.extend({
                ajaxyForms: function (opts) {
                    var $form = $(this);
                    opts      = $.extend({}, {
                        urlencode:  null,
                        onResponse: function (rsp) {
                            $form.replaceWith($(rsp));
                        }
                    }, opts);

                    $form.on("submit", function (e) {
                        // Initialize
                        var $form     = $(this);
                        var urlencode = opts.urlencode;

                        // Autoconf
                        if (urlencode === null) {
                            // If it's null, we autodetect
                            urlencode = $form.find("input[type=file]:first").size() == 0;
                        }

                        // Setup
                        var data;
                        var contentType;

                        // Configure
                        if (urlencode) {
                            data        = $.map($form.serializeArray(), function (v) {
                                return encodeURIComponent(v.name) + "=" + encodeURIComponent(v.value);
                            }).join("&");
                            contentType = "application/x-www-form-urlencoded; charset=UTF-8";
                        } else {
                            data        = new FormData(this);
                            contentType = false;
                        }

                        // Meat
                        $.ajax({
                                   url:         $form.attr("action"),
                                   type:        $form.attr("method"),
                                   processData: false,
                                   contentType: contentType,
                                   data:        data,
                                   success:     opts.onResponse
                               });

                        // Prevent default form behavior
                        e.stopImmediatePropagation();
                        return false;
                    });
                }
            });
