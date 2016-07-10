using System;
using System.Collections.Generic;

namespace RemoveDuplicationsCSharp
{
  internal class Program
  {
    private static void RemoveDuplicatesWithTempBuffer(LinkedList<int> list)
    {
      var d = new HashSet<int>();
      var node = list.First;
      while (node != null)
      {
        var next = node.Next;
        if (d.Contains(node.Value))
        {
          list.Remove(node);
        }
        else
        {
          d.Add(node.Value);
        }
        node = next;
      }
    }

    private static void RemoveDuplicatesWithoutTempBuffer(LinkedList<int> list)
    {
      var i = list.First;
      while (i != null)
      {
        var j = i.Next;
        while (j != null)
        {
          var next = j.Next;
          if (i.Value == j.Value)
          {
            list.Remove(j);
          }
          j = next;
        }
        i = i.Next;
      }
    }

    static void Main()
    {
      var list = new LinkedList<int>(new [] { 4, 3, 5, 4, 3, 1, 0, 10});
      //RemoveDuplicatesWithTempBuffer(list);
      RemoveDuplicatesWithoutTempBuffer(list);
      Console.WriteLine(string.Join(",", list));
    }
  }
}


