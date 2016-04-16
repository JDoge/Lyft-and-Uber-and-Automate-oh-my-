using LyftUberApi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace LyftUberApi.Controllers
{
    [RoutePrefix("api")]
    public class NotificationController : ApiController
    {
        // POST api/Account/Logout
        [Route("notifications")]
        [HttpPost]
        public IHttpActionResult Notification([FromBody]Notification notification)
        {

            return Ok(notification);
        }
    }
}
