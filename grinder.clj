;; The Grinder 3.11
;; HTTP script recorded by TCPProxy at Jan 18, 2015 8:39:08 PM

(ns user
  (:import (net.grinder.script Test Grinder)
           (net.grinder.plugin.http HTTPPluginControl HTTPRequest)
           (HTTPClient NVPair Codecs)))

(def grinder (Grinder/grinder))
(def connectionDefaults (HTTPPluginControl/getConnectionDefaults))
(def httpUtilities (HTTPPluginControl/getHTTPUtilities))

;; To use a proxy server, uncomment the next line and set the host and port.
;; (.setProxyServer connectionDefaults "localhost" 8001)

;; Worker thread state is stored in a map using a dynamic var.
(def ^:dynamic *tokens*)
(defn set-token [k v] (set! *tokens* (assoc *tokens* k v)))
(defn token [k] (*tokens* k))

(defn nvpairs [c] (into-array NVPair
                              (map (fn [[k v]] (NVPair. k v)) (partition 2 c))))

(defn httprequest [url & [headers]]
  (doto (HTTPRequest.) (.setUrl url) (.setHeaders (nvpairs headers))))

(defn basic-authorization [u p]
  (str "Basic " (Codecs/base64Encode  (str u ":" p))))

(defn to-bytes [s]
  (letfn [(to-byte[x] (byte (if (> x 0x7f) (- x 0x100) x)))]
    (byte-array (map to-byte s))))

(defmacro defrequest [name test & args]
  `(do
     (def ~name (httprequest ~@args))
     (.record ~test ~name (HTTPRequest/getHttpMethodFilter))))

(defmacro defpage [name description test & rest]
  `(do
     (defn ~name ~description ~@rest)
     (.record ~test ~name)))

;; Offline debug
;; (use '[clojure.string :only (join)])
;; (defmacro .GET [& k] `(.. grinder (getLogger) (debug (str "GET " (join ", " `(~~@k))))))
;; (defmacro .POST [& k] `(.. grinder (getLogger) (debug (str "POST " (join ", " `(~~@k))))))


(.setDefaultHeaders connectionDefaults
                    (nvpairs ["Accept-Language", "en-US,en;q=0.8,sk;q=0.6,cs;q=0.4"
                              "User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.111 Safari/537.36"
                              "Accept-Encoding", "gzip,deflate,sdch"]))

(def headers0 ["Accept", "*/*"
               "Referer", "http://localhost:3000";;"http://green-recipes.com/"
               ])

(def headers1 ["Accept", "image/webp,*/*;q=0.8"
               "Referer", "http://localhost:3000";;"http://green-recipes.com/"
               ])

(def headers2 ["Accept", "image/webp,*/*;q=0.8"
               "Referer", "http://localhost:3000/style.css";;"http://green-recipes.com/style.css"
               ])

(def headers3 ["Accept", "*/*"
               "Referer", "http://localhost:3000/style.css";;"http://green-recipes.com/style.css"
               ])

(def url0 "http://localhost:3000";;"http://green-recipes.com:80"
  )

(defrequest request101 (Test. 101 "GET /") url0)

(defrequest request102 (Test. 102 "GET style.css") url0)

(defrequest request103 (Test. 103 "GET base.js") url0 headers0)

(defrequest request104 (Test. 104 "GET zelenerecepty_app.js") url0 headers0)

(defrequest request105 (Test. 105 "GET facebook-link.png") url0 headers1)

(defrequest request106 (Test. 106 "GET sk-logo-mini.png") url0 headers1)

(defrequest request107 (Test. 107 "GET guacamole.jpg") url0 headers1)

(defrequest request108 (Test. 108 "GET brokolicovy-salat.jpg") url0 headers1)

(defrequest request109 (Test. 109 "GET sunflower-bread.jpg") url0 headers1)

(defrequest request110 (Test. 110 "GET choco-mint.jpg") url0 headers1)

(defrequest request111 (Test. 111 "GET horcica.jpg") url0 headers1)

(defrequest request112 (Test. 112 "GET pizza.jpg") url0 headers1)

(defrequest request113 (Test. 113 "GET deps.js") url0 headers0)

(defrequest request114 (Test. 114 "GET carob-cookies.jpg") url0 headers1)

(defrequest request115 (Test. 115 "GET basic-cashew-cheese.jpg") url0 headers1)

(defrequest request116 (Test. 116 "GET tahini-dresing.jpg") url0 headers1)

(defrequest request117 (Test. 117 "GET wrap.jpg") url0 headers1)

(defrequest request118 (Test. 118 "GET error.js") url0 headers0)

(defrequest request119 (Test. 119 "GET nodetype.js") url0 headers0)

(defrequest request120 (Test. 120 "GET string.js") url0 headers0)

(defrequest request121 (Test. 121 "GET asserts.js") url0 headers0)

(defrequest request122 (Test. 122 "GET array.js") url0 headers0)

(defrequest request123 (Test. 123 "GET util.js") url0 headers0)

(defrequest request124 (Test. 124 "GET browser.js") url0 headers0)

(defrequest request125 (Test. 125 "GET engine.js") url0 headers0)

(defrequest request126 (Test. 126 "GET useragent.js") url0 headers0)

(defrequest request127 (Test. 127 "GET browserfeature.js") url0 headers0)

(defrequest request128 (Test. 128 "GET tagname.js") url0 headers0)

(defrequest request129 (Test. 129 "GET functions.js") url0 headers0)

(defrequest request130 (Test. 130 "GET math.js") url0 headers0)

(defrequest request131 (Test. 131 "GET coordinate.js") url0 headers0)

(defrequest request132 (Test. 132 "GET size.js") url0 headers0)

(defrequest request133 (Test. 133 "GET object.js") url0 headers0)

(defrequest request134 (Test. 134 "GET dom.js") url0 headers0)

(defrequest request135 (Test. 135 "GET core.js") url0 headers0)

(defrequest request136 (Test. 136 "GET stringbuffer.js") url0 headers0)

(defrequest request137 (Test. 137 "GET iter.js") url0 headers0)

(defrequest request138 (Test. 138 "GET map.js") url0 headers0)

(defrequest request139 (Test. 139 "GET forms.js") url0 headers0)

(defrequest request140 (Test. 140 "GET classes.js") url0 headers0)

(defrequest request141 (Test. 141 "GET entrypointregistry.js") url0 headers0)

(defrequest request142 (Test. 142 "GET browserfeature.js") url0 headers0)

(defrequest request143 (Test. 143 "GET idisposable.js") url0 headers0)

(defrequest request144 (Test. 144 "GET disposable.js") url0 headers0)

(defrequest request145 (Test. 145 "GET eventid.js") url0 headers0)

(defrequest request146 (Test. 146 "GET event.js") url0 headers0)

(defrequest request147 (Test. 147 "GET eventtype.js") url0 headers0)

(defrequest request148 (Test. 148 "GET reflect.js") url0 headers0)

(defrequest request149 (Test. 149 "GET browserevent.js") url0 headers0)

(defrequest request150 (Test. 150 "GET listenable.js") url0 headers0)

(defrequest request151 (Test. 151 "GET listener.js") url0 headers0)

(defrequest request152 (Test. 152 "GET listenermap.js") url0 headers0)

(defrequest request153 (Test. 153 "GET events.js") url0 headers0)

(defrequest request154 (Test. 154 "GET support.js") url0 headers0)

(defrequest request155 (Test. 155 "GET vendor.js") url0 headers0)

(defrequest request156 (Test. 156 "GET box.js") url0 headers0)

(defrequest request157 (Test. 157 "GET rect.js") url0 headers0)

(defrequest request158 (Test. 158 "GET style.js") url0 headers0)

(defrequest request159 (Test. 159 "GET string.js") url0 headers0)

(defrequest request160 (Test. 160 "GET xml.js") url0 headers0)

(defrequest request161 (Test. 161 "GET domina.js") url0 headers0)

(defrequest request162 (Test. 162 "GET query.js") url0 headers0)

(defrequest request163 (Test. 163 "GET css.js") url0 headers0)

(defrequest request164 (Test. 164 "GET events.js") url0 headers0)

(defrequest request165 (Test. 165 "GET smoothscroll.js") url0 headers0)

(defrequest request166 (Test. 166 "GET eventtarget.js") url0 headers0)

(defrequest request167 (Test. 167 "GET timer.js") url0 headers0)

(defrequest request168 (Test. 168 "GET json.js") url0 headers0)

(defrequest request169 (Test. 169 "GET structs.js") url0 headers0)

(defrequest request170 (Test. 170 "GET collection.js") url0 headers0)

(defrequest request171 (Test. 171 "GET set.js") url0 headers0)

(defrequest request172 (Test. 172 "GET debug.js") url0 headers0)

(defrequest request173 (Test. 173 "GET logrecord.js") url0 headers0)

(defrequest request174 (Test. 174 "GET logbuffer.js") url0 headers0)

(defrequest request175 (Test. 175 "GET logger.js") url0 headers0)

(defrequest request176 (Test. 176 "GET log.js") url0 headers0)

(defrequest request177 (Test. 177 "GET errorcode.js") url0 headers0)

(defrequest request178 (Test. 178 "GET eventtype.js") url0 headers0)

(defrequest request179 (Test. 179 "GET httpstatus.js") url0 headers0)

(defrequest request180 (Test. 180 "GET xhrlike.js") url0 headers0)

(defrequest request181 (Test. 181 "GET xmlhttpfactory.js") url0 headers0)

(defrequest request182 (Test. 182 "GET wrapperxmlhttpfactory.js") url0 headers0)

(defrequest request183 (Test. 183 "GET xmlhttp.js") url0 headers0)

(defrequest request184 (Test. 184 "GET utils.js") url0 headers0)

(defrequest request185 (Test. 185 "GET xhrio.js") url0 headers0)

(defrequest request186 (Test. 186 "GET eventtype.js") url0 headers0)

(defrequest request187 (Test. 187 "GET eventhandler.js") url0 headers0)

(defrequest request188 (Test. 188 "GET event.js") url0 headers0)

(defrequest request189 (Test. 189 "GET device.js") url0 headers0)

(defrequest request190 (Test. 190 "GET memoize.js") url0 headers0)

(defrequest request191 (Test. 191 "GET history.js") url0 headers0)

(defrequest request192 (Test. 192 "GET walk.js") url0 headers0)

(defrequest request193 (Test. 193 "GET core.js") url0 headers0)

(defrequest request194 (Test. 194 "GET thumbnail.js") url0 headers0)

(defrequest request195 (Test. 195 "GET jahodova-limonada.jpg") url0 headers1)

(defrequest request196 (Test. 196 "GET spinach-basil-pesto.jpg") url0 headers1)

(defrequest request197 (Test. 197 "GET up.png") url0 headers1)

(defrequest request198 (Test. 198 "GET birds_and_sign.png") url0 headers1)

(defrequest request199 (Test. 199 "GET chibi.png") url0 headers2)

(defrequest request201 (Test. 201 "GET mathilde.otf") url0 headers3)

(defrequest request202 (Test. 202 "GET green.jpg") url0 headers2)

(defrequest request301 (Test. 301 "GET LiberationSans-Regular.ttf") url0 headers3)

(defrequest request302 (Test. 302 "GET background_home.png") url0 headers2)


;; A function for each recorded page.
(defpage page1 "GET / (requests 101-199)." (Test. 100 "Page 1") []
  (.GET request101 "/" nil
        (nvpairs ["Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8"]))
  ;; 2 different values for token_family found in response, using the first one.
  (set-token :token_family (.valueFromBodyURI httpUtilities "family") ;; "Roboto:400,100,300,500"
             )
  ;; 2 different values for token_lang found in response, using the first one.
  (set-token :token_lang (.valueFromBodyURI httpUtilities "lang") ;; "en"
             )
  (set-token :token_screen_name (.valueFromBodyURI httpUtilities "screen_name") ;; "zelenerecepty"
             )

  (.sleep grinder 167)
  (.GET request102 "/style.css" nil
        (nvpairs [
                  "Accept", "text/css,*/*;q=0.1"
                  "Referer", "http://green-recipes.com/"]))

  (.GET request103 "/out/goog/base.js")

  (.GET request104 "/script/zelenerecepty_app.js")

  (.GET request105 "/images/facebook-link.png")

  (.GET request106 "/images/sk-logo-mini.png")

  (.sleep grinder 45)
  (.GET request107 "/images/thumbnails/guacamole.jpg")

  (.GET request108 "/images/thumbnails/brokolicovy-salat.jpg")

  (.GET request109 "/images/thumbnails/sunflower-bread.jpg")

  (.GET request110 "/images/thumbnails/choco-mint.jpg")

  (.sleep grinder 20)
  (.GET request111 "/images/thumbnails/horcica.jpg" nil
        (nvpairs [
                  "If-Modified-Since", "Mon, 01 Dec 2014 18:43:42 GMT"]))

  (.GET request112 "/images/thumbnails/pizza.jpg")

  (.GET request113 "/out/goog/deps.js")

  (.sleep grinder 71)
  (.GET request114 "/images/thumbnails/carob-cookies.jpg")

  (.GET request115 "/images/thumbnails/basic-cashew-cheese.jpg")

  (.sleep grinder 57)
  (.GET request116 "/images/thumbnails/tahini-dresing.jpg")

  (.GET request117 "/images/thumbnails/wrap.jpg")

  (.GET request118 "/out/goog/debug/error.js")

  (.GET request119 "/out/goog/dom/nodetype.js")

  (.GET request120 "/out/goog/string/string.js")

  (.GET request121 "/out/goog/asserts/asserts.js")

  (.GET request122 "/out/goog/array/array.js")

  (.GET request123 "/out/goog/labs/useragent/util.js")

  (.GET request124 "/out/goog/labs/useragent/browser.js")

  (.sleep grinder 30)
  (.GET request125 "/out/goog/labs/useragent/engine.js")

  (.sleep grinder 27)
  (.GET request126 "/out/goog/useragent/useragent.js")

  (.GET request127 "/out/goog/dom/browserfeature.js")

  (.sleep grinder 12)
  (.GET request128 "/out/goog/dom/tagname.js")

  (.GET request129 "/out/goog/functions/functions.js")

  (.sleep grinder 18)
  (.GET request130 "/out/goog/math/math.js")

  (.GET request131 "/out/goog/math/coordinate.js")

  (.GET request132 "/out/goog/math/size.js")

  (.GET request133 "/out/goog/object/object.js")

  (.sleep grinder 17)
  (.GET request134 "/out/goog/dom/dom.js")

  (.GET request135 "/out/cljs/core.js")

  (.GET request136 "/out/goog/string/stringbuffer.js")

  (.sleep grinder 12)
  (.GET request137 "/out/goog/iter/iter.js")

  (.GET request138 "/out/goog/structs/map.js")

  (.sleep grinder 37)
  (.GET request139 "/out/goog/dom/forms.js")

  (.sleep grinder 21)
  (.GET request140 "/out/goog/dom/classes.js")

  (.GET request141 "/out/goog/debug/entrypointregistry.js")

  (.GET request142 "/out/goog/events/browserfeature.js")

  (.GET request143 "/out/goog/disposable/idisposable.js")

  (.sleep grinder 18)
  (.GET request144 "/out/goog/disposable/disposable.js")

  (.GET request145 "/out/goog/events/eventid.js")

  (.GET request146 "/out/goog/events/event.js")

  (.GET request147 "/out/goog/events/eventtype.js")

  (.GET request148 "/out/goog/reflect/reflect.js")

  (.GET request149 "/out/goog/events/browserevent.js")

  (.sleep grinder 27)
  (.GET request150 "/out/goog/events/listenable.js")

  (.GET request151 "/out/goog/events/listener.js")

  (.GET request152 "/out/goog/events/listenermap.js")

  (.GET request153 "/out/goog/events/events.js")

  (.sleep grinder 22)
  (.GET request154 "/out/domina/support.js")

  (.GET request155 "/out/goog/dom/vendor.js")

  (.sleep grinder 25)
  (.GET request156 "/out/goog/math/box.js")

  (.GET request157 "/out/goog/math/rect.js")

  (.GET request158 "/out/goog/style/style.js")

  (.sleep grinder 35)
  (.GET request159 "/out/clojure/string.js")

  (.GET request160 "/out/goog/dom/xml.js")

  (.GET request161 "/out/domina.js")

  (.sleep grinder 30)
  (.GET request162 "/out/goog/dojo/dom/query.js")

  (.GET request163 "/out/domina/css.js")

  (.sleep grinder 40)
  (.GET request164 "/out/domina/events.js")

  (.GET request165 "/out/zelene_recepty/smoothscroll.js")

  (.GET request166 "/out/goog/events/eventtarget.js")

  (.GET request167 "/out/goog/timer/timer.js")

  (.GET request168 "/out/goog/json/json.js")

  (.GET request169 "/out/goog/structs/structs.js")

  (.GET request170 "/out/goog/structs/collection.js")

  (.sleep grinder 18)
  (.GET request171 "/out/goog/structs/set.js")

  (.GET request172 "/out/goog/debug/debug.js")

  (.GET request173 "/out/goog/debug/logrecord.js")

  (.GET request174 "/out/goog/debug/logbuffer.js")

  (.sleep grinder 21)
  (.GET request175 "/out/goog/debug/logger.js")

  (.sleep grinder 21)
  (.GET request176 "/out/goog/log/log.js")

  (.sleep grinder 25)
  (.GET request177 "/out/goog/net/errorcode.js")

  (.GET request178 "/out/goog/net/eventtype.js")

  (.GET request179 "/out/goog/net/httpstatus.js")

  (.GET request180 "/out/goog/net/xhrlike.js")

  (.GET request181 "/out/goog/net/xmlhttpfactory.js")

  (.GET request182 "/out/goog/net/wrapperxmlhttpfactory.js")

  (.GET request183 "/out/goog/net/xmlhttp.js")

  (.sleep grinder 13)
  (.GET request184 "/out/goog/uri/utils.js")

  (.GET request185 "/out/goog/net/xhrio.js")

  (.GET request186 "/out/goog/history/eventtype.js")

  (.GET request187 "/out/goog/events/eventhandler.js")

  (.GET request188 "/out/goog/history/event.js")

  (.GET request189 "/out/goog/labs/useragent/device.js")

  (.GET request190 "/out/goog/memoize/memoize.js")

  (.GET request191 "/out/goog/history/history.js")

  (.sleep grinder 15)
  (.GET request192 "/out/clojure/walk.js")

  (.GET request193 "/out/secretary/core.js")

  (.GET request194 "/out/zelene_recepty/thumbnail.js")

  (.sleep grinder 36)
  (.GET request195 "/images/thumbnails/jahodova-limonada.jpg" nil
        (nvpairs [
                  "If-Modified-Since", "Mon, 01 Dec 2014 18:43:42 GMT"]))

  (.sleep grinder 48)
  (.GET request196 "/images/thumbnails/spinach-basil-pesto.jpg")

  (.sleep grinder 175)
  (.GET request197 "/images/up.png")

  (.sleep grinder 86)
  (.GET request198 "/images/birds_and_sign.png")

  (.sleep grinder 772)
  (.GET request199 "/images/chibi.png")
  )

(defpage page2 "GET mathilde.otf (requests 201-202)." (Test. 200 "Page 2") []
  (.GET request201 "/font/mathilde.otf")

  (.GET request202 "/images/green.jpg")
  )

(defpage page3 "GET LiberationSans-Regular.ttf (requests 301-302)." (Test. 300 "Page 3") []
  (.GET request301 "/font/LiberationSans-Regular.ttf")

  (.GET request302 "/images/background_home.png")
  )


(defn run
  "Called for every run performed by the worker thread." []

  (page1)      ; GET / (requests 101-199)
  (page2)      ; GET mathilde.otf (requests 201-202)
  (page3)      ; GET LiberationSans-Regular.ttf (requests 301-302)
  )

(defn runner-factory
  "Create a run function. Called for each worker thread." []
  (binding [*tokens* {}] (bound-fn* run)))
