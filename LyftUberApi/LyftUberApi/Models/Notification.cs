using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LyftUberApi.Models
{
    public class Notification
    {
        private string _packageName;
        private string _provider;
        private string _data;

        public Notification(string packageName, string provider, string data)
        {
            _packageName = packageName;
            _provider = provider;
            _data = data;
        }

        public string PackageName 
        { 
            get 
            {
                return _packageName;
            }
         }

        public string Provider 
        { 
            get 
            {
                return _provider;
            }
         }

        public string Data 
        { 
            get 
            {
                return _data;
            }
         }
        
    }
}

