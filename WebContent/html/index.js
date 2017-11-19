window.onload = function myFunc() {
	var reqs = document.getElementsByClassName("request");
	for (var i = 0; i < reqs.length; i++) {
		var req = reqs[i];
		// 为每个列表添加点击事件
		req.onclick = function() {
			// 此处必须用this
			var url = this.getAttribute("data-url");
			loadXMLDoc(url);
		}

		// Ajax 加载
		function loadXMLDoc(url) {
			// 1、建立XMLHttpRequest 请求
			var xmlhttp;
			if (window.XMLHttpRequest) { // IE浏览器 IE7 8 360等
				xmlhttp = new XMLHttpRequest();
			} else {// IE5、6
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			/**
			 * 2、 open(method, url, async) 发送请求 send() 发送参数 如果post方式 设置请求头信息
			 * request.setRequestHeader("Content-Type",
			 * "application/x-www-form-urlencoded");
			 */
			xmlhttp.open("get", url, true);
			xmlhttp.responseType = "blob";
			xmlhttp.send();
			// 3、 设置回调函数
			xmlhttp.onreadystatechange = function() {				
				
				if (this.readyState == 4 && this.status == 200) {
					// 4、 处理返回数据
//					var blob = this.response;
//					var img = document.createElement("img");
//					img.onload = function(e) {
//						window.URL.revokeObjectURL(img.src);
//					}
//					img.src = window.URL.createObjectURL(blob);
					var right = document.getElementById("right");					
//					//right.appendChild(img);
//					right.innerText += img.src;
					right.innerText = "刷新数据";
				}
			}
		}
	}
};
